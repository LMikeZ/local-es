package com.example.lizan.aspect.ann;


import com.example.lizan.zlock.ZLockConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zhaocheng
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Import(ZLockConfig.class)
public @interface EnableZLock {

}
