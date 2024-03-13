package com.example.lizan.zlock;


import com.example.lizan.aspect.ann.ZLockable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author zhaocheng
 */
@Aspect
@Order(10)
public class DistributedLockableAspect implements KeyGenerator {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    private ZLockClient redisLockClient;


    /**
     * {@link ZLockable}
     *
     * @author zhaocheng
     */
    @Pointcut(value = "execution(* *(..)) && @annotation(com.abcpen.zlock.annotation.ZLockable)")
    public void distributedLockable() {
    }

    /**
     * @param joinPoint
     * @param lockable
     * @return
     * @throws Throwable
     * @author zhaocheng
     */
    @Around(value = "distributedLockable() && @annotation(lockable)")
    public Object around(ProceedingJoinPoint joinPoint, ZLockable lockable) throws Throwable {
        long start = System.nanoTime();


        String key;

        if (StringUtils.isEmpty(lockable.key())) {
            key = this.generate(joinPoint, lockable.prefix(), lockable.argNames(), lockable.argsAssociated()).toString();
        } else {
            key = parseSpelKey(joinPoint, lockable.key());
            if (StringUtils.isEmpty(key)) {
                throw new RuntimeException("ZLockable key parse error ");
            }
        }
        Object result = redisLockClient.tryLock(
                key, () -> joinPoint.proceed(),
                lockable.unit().toMillis(lockable.timeout()), lockable.autoUnlock(),
                lockable.retries(), lockable.unit().toMillis(lockable.waitingTime()),
                lockable.onFailure(),lockable
        );

        long end = System.nanoTime();
        LOGGER.debug("distributed lockable cost: {} ns", end - start);
        return result;
    }

    private String parseSpelKey(ProceedingJoinPoint joinPoint, String key) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return SPELKeyParse.parseSpel(method, joinPoint.getArgs(), key, String.class, "");
    }

}
