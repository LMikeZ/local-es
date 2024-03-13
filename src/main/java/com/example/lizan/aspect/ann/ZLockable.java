package com.example.lizan.aspect.ann;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * distributed lock
 *
 * @author zhaocheng
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ZLockable {

    /**
     * timeout of the lock
     *
     * @return
     * @author zhaocheng
     */
    long timeout() default 30L;

    /**
     * time unit
     *
     * @return
     * @author zhaocheng
     */
    TimeUnit unit() default TimeUnit.SECONDS;

    /**
     * number of retries
     *
     * @return
     * @author zhaocheng
     */
    int retries() default 0;

    /**
     * interval of each retry
     *
     * @return
     * @author zhaocheng
     */
    long waitingTime() default 30L;

    /**
     * key prefix
     *
     * @return
     * @author zhaocheng
     */
    String prefix() default "";

    /**
     * parameters that construct a key
     *
     * @return
     * @author zhaocheng
     */
    String[] argNames() default {};

    /**
     * construct a key with parameters
     *
     * @return
     * @author zhaocheng
     */
    boolean argsAssociated() default true;

    /**
     * spel key
     *
     * @return
     */
    String key() default "";

    /**
     * whether unlock when completed
     *
     * @return
     * @author zhaocheng
     */
    boolean autoUnlock() default true;

    /**
     * 续期
     *
     * @return
     */
    boolean renewal() default true;

    /**
     * 续期时间 默认10s 单位秒
     * @return
     */
    long renewalTs() default 10;

    /**
     * 间隔多久 续期 默认3s
     * @return
     */
    long intervalRenew() default 3;

    /**
     * throw an runtime exception while fail to get lock
     *
     * @return
     * @author zhaocheng
     */
    Class<? extends RuntimeException> onFailure() default NoException.class;

    /**
     * no exception
     *
     * @author zhaocheng
     */
    final class NoException extends RuntimeException {

        private static final long serialVersionUID = -7821936618527445658L;

    }
}
