package com.example.lizan.eventBus.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 11:46
 * @Description TODO
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface OnEventInterceptor {

}
