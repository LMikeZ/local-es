package com.example.lizan.eventBus.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 16:27
 * @Description TODO
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscriber {

    Schedule schedule() default Schedule.MAIN;

    boolean receiveAssignableFromClz() default false;

    boolean receiveProxyClz() default false;

}
