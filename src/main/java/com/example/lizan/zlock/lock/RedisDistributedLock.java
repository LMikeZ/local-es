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
package com.example.lizan.zlock.lock;


import com.example.lizan.aspect.ann.ZLockable;
import com.example.lizan.zlock.RenewLockValueChangeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis distributed lock
 *
 * @since JDK 1.8
 */
@Slf4j
public class RedisDistributedLock extends DistributedLock {

    private RedisOperations<String, String> operations;
    private String key;
    private String value;

    private Long timeoutTS;
    private boolean autoUnlock;

    private ZLockable zLockable;

    private Long startTimeTS;

    private static final String COMPARE_AND_DELETE =
            "if redis.call('get',KEYS[1]) == ARGV[1]\n" +
                    "then\n" +
                    "    return redis.call('del',KEYS[1])\n" +
                    "else\n" +
                    "    return 0\n" +
                    "end";

    /**
     * @param operations
     * @param key
     * @param value
     */
    public RedisDistributedLock(RedisOperations<String, String> operations,
                                String key, String value,
                                boolean autoUnlock, Long timeoutTs, ZLockable zLockable) {
        this.operations = operations;
        this.key = key;
        this.value = value;
        this.autoUnlock = autoUnlock;
        this.timeoutTS = timeoutTs;
        this.zLockable = zLockable;
        this.startTimeTS = System.currentTimeMillis();
    }

    @Override
    public void release() {
        if (!autoUnlock) return;
        List<String> keys = Collections.singletonList(key);
        operations.execute(new DefaultRedisScript<>(COMPARE_AND_DELETE, Object.class), keys, value);
    }

    @Override
    public long timeoutTS() {
        return timeoutTS;
    }

    @Override
    public long intervalRenew() {
        return zLockable.intervalRenew();
    }

    @Override
    public void renewalTimeout() throws RenewLockValueChangeException {

        timeoutTS = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(zLockable.renewalTs());
        String s = operations.opsForValue().get(key);
        if (StringUtils.equals(s, value)) {
            log.info("续期锁 {} , 已占用锁时间:{}s", key, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTimeTS));
            operations.expire(key, zLockable.renewalTs(), TimeUnit.SECONDS);
        } else {
            log.warn("锁已被修改 无法续期 {}", key);
            throw new RenewLockValueChangeException(key);
        }

    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RedisDistributedLock [key=" + key + ", value=" + value + "]";
    }

}
