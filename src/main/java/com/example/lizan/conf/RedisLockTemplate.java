package com.example.lizan.conf;

/**
 * @author lizan
 * @version $Id: RedisLockTemplate.java, v 0.1 2022年06月07日 19:53 lizan Exp $$
 */


import com.example.lizan.error.BizException;
import com.example.lizan.error.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
public class RedisLockTemplate {
    private static Logger log = LoggerFactory.getLogger(RedisLockTemplate.class);
    private static final ErrorInfo waitErrorInfo = new ErrorInfo(800L, "系统繁忙，请稍后再试", "系统繁忙，请稍后再试");
    private StringRedisTemplate stringRedisTemplate;
    private boolean lock;
    private String key;
    private Object value;

    public RedisLockTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public RedisLockTemplate tryLock(String key, long lockTime, TimeUnit timeUnit) {
        this.key = key;

        try {
            this.lock = this.stringRedisTemplate.opsForValue().setIfAbsent(key, "1", lockTime, timeUnit);
            log.debug("[tryLock] key:{} success:{}", key, this.lock);
        } catch (Exception var6) {
            log.error("[tryLock] error key:{}", key, var6);
        }

        return this;
    }

    public RedisLockTemplate lock(String key, long lockTime, TimeUnit timeUnit, long timeoutMill) {
        long retry = timeoutMill / 500L;

        for (int i = 0; (long) i < retry; ++i) {
            this.tryLock(key, lockTime, timeUnit);
            if (this.lock) {
                return this;
            }

            try {
                Thread.sleep(500L);
            } catch (InterruptedException var11) {
                var11.printStackTrace();
            }
        }

        return this;
    }

    public RedisLockTemplate ifSuccess(Supplier supplier) {
        if (!this.lock) {
            return this;
        } else {
            try {
                this.value = supplier.get();
            } finally {
                this.unlock(this.key);
            }

            return this;
        }
    }

    public RedisLockTemplate ifSuccess(Runnable runnable) {
        if (!this.lock) {
            return this;
        } else {
            try {
                runnable.run();
            } finally {
                this.unlock(this.key);
            }

            return this;
        }
    }

    public RedisLockTemplate ifError(Supplier supplier) {
        if (this.lock) {
            return this;
        } else {
            this.value = supplier.get();
            return this;
        }
    }

    public RedisLockTemplate ifError(Runnable runnable) {
        if (this.lock) {
            return this;
        } else {
            runnable.run();
            return this;
        }
    }

    public RedisLockTemplate ifError(Supplier waitSuccess, int retryTime, int interval, Supplier<BizException> waitError) {
        if (this.lock) {
            return this;
        }
        for (int i = 0; i < retryTime; ++i) {
            try {
                Thread.sleep((long) interval);
            } catch (InterruptedException var8) {
                var8.printStackTrace();
            }

            try {
                this.value = waitSuccess.get();
            } catch (Exception var7) {
                log.error("[ifError] error, key:{}", this.key, var7);
            }

            if (this.value != null) {
                return this;
            }
        }

        BizException exception = (BizException) waitError.get();
        if (exception != null) {
            throw exception;
        } else {
            throw new BizException(waitErrorInfo);
        }
    }

    public Object get() {
        return this.value;
    }

    private void unlock(String key) {
        if (this.lock) {
            try {
                this.stringRedisTemplate.delete(key);
                log.debug("[unlock] key:{}", key);
            } catch (Exception var3) {
                log.error("[unlock] error key:{}", key, var3);
            }

        }
    }

    public RedisLockTemplate create() {
        try {
            return new RedisLockTemplate(this.stringRedisTemplate);
        } catch (Throwable var2) {
            throw var2;
        }
    }
}
