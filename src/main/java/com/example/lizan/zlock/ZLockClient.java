/*
 *
 * Copyright 2019 zhaocheng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.lizan.zlock;


import com.example.lizan.aspect.ann.ZLockable;
import com.example.lizan.zlock.lock.DistributedLock;
import com.example.lizan.zlock.lock.RedisDistributedLock;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaocheng
 */
public class ZLockClient {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private StringRedisTemplate stringRedisTemplate;


    private final Object sentinelWait = new Object();

    private HashMap<String, DistributedLock> renewalLockKey = new HashMap<>();

    private final ExecutorService sentinelLockThread = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), new CustomThreadFactory("zlock-sentinel"));

    public ZLockClient(StringRedisTemplate redisTemplate) {
        this.stringRedisTemplate = redisTemplate;
        sentinelLockThread.submit(this::sentinel);

    }

    private void sentinel() {
        while (true) {
            try {
                if (renewalLockKey.size() > 0) {
                    Set<String> item = new HashSet<>(renewalLockKey.keySet());
                    for (String s : item) {
                       final DistributedLock value = renewalLockKey.get(s);
                        if (value != null) {
                            if (value.timeoutTS() - System.currentTimeMillis() < TimeUnit.SECONDS.toMillis(value.intervalRenew())) {
                                synchronized (value) {
                                    if (renewalLockKey.containsKey(s)) {
                                        value.renewalTimeout();
                                    }
                                }
                            }
                        }
                    }
                    Thread.yield();
                } else {
                    synchronized (sentinelWait) {
                        sentinelWait.wait(30000);
                    }
                }

            } catch (RenewLockValueChangeException renewLockErrorException) {
                renewalLockKey.remove(renewLockErrorException.getKey());
            } catch (Throwable t) {
                LOGGER.error("sentinel error", t);
            }
        }
    }


    public static final class CustomThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger index = new AtomicInteger(1);

        public CustomThreadFactory(String namePrefix) {
            this.namePrefix = namePrefix;
            group = Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix
                    + index.getAndIncrement());
            t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }


    public <T> T tryLock(String key, LockHandler<T> handler, long timeout, boolean autoUnlock, int retries, long waitingTime,
                         Class<? extends RuntimeException> onFailure, ZLockable lockable) throws Throwable {

        try (final DistributedLock lock = this.acquire(key, timeout, retries, waitingTime, autoUnlock, lockable)) {
            if (lock != null) {
                LOGGER.debug("get lock success, key: {}", key);
                try {
                    if (lockable.renewal()) {
                        renewalLockKey.put(key, lock);
                        synchronized (sentinelWait) {
                            sentinelWait.notify();
                        }
                    }
                    return handler.handle();
                } finally {
                    if (autoUnlock) {
                        LOGGER.debug("remove lock key: {}", key);
                        synchronized (lock) {
                            renewalLockKey.remove(key);
                            stringRedisTemplate.delete(key);
                        }

                    }
                }
            }
            LOGGER.debug("get lock fail, key: {}", key);
            if (null != onFailure && onFailure != ZLockable.NoException.class) {
                throw onFailure.newInstance();
            }
            return null;
        }
    }


    public DistributedLock acquire(String key, long timeout, int retries, long waitingTime, boolean autoUnlock, ZLockable lockable) throws InterruptedException {

        final String value = RandomStringUtils.randomAlphanumeric(4) + System.currentTimeMillis();
        do {
            Long timeoutTs = System.currentTimeMillis() + timeout;
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.MILLISECONDS);
            if (result) {
                return new RedisDistributedLock(stringRedisTemplate, key, value, autoUnlock, timeoutTs, lockable);
            }
            if (retries > NumberUtils.INTEGER_ZERO) {
                TimeUnit.MILLISECONDS.sleep(waitingTime);
            }
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
        } while (retries-- > NumberUtils.INTEGER_ZERO);

        return null;
    }

}
