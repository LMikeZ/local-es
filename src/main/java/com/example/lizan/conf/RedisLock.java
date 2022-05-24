package com.example.lizan.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author lizan
 * @version $Id: RedisLock.java, v 0.1 2022年04月14日 16:17 lizan Exp $$
 */
public class RedisLock {
    private static final Logger log = LoggerFactory.getLogger(RedisLock.class);
    private StringRedisTemplate stringRedisTemplate;

    public RedisLock(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public boolean tryLock(String key, long lockTime, TimeUnit timeUnit) {
        try {
            boolean lock = this.stringRedisTemplate.opsForValue().setIfAbsent(key, "1", lockTime, timeUnit);
            if (!lock) {
                log.error("[tryLock] failed key:{}", key);
                return false;
            } else {
                log.info("[tryLock] success key:{}", key);
                return lock;
            }
        } catch (Exception var6) {
            log.error("[tryLock] error key:{}", key, var6);
            return false;
        }
    }

    public void unlock(String key) {
        try {
            this.stringRedisTemplate.delete(key);
            log.info("[unlock] success key:{}", key);
        } catch (Exception var3) {
            log.error("[unlock] error key:{}", key, var3);
        }

    }
}