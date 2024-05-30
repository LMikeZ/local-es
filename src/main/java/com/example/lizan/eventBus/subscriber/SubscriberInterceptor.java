package com.example.lizan.eventBus.subscriber;

import java.lang.reflect.Method;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2021-01-18 14:57
 * @Description
 */
public interface SubscriberInterceptor {

    int order();

    default boolean onPreEvent(Object event) {
        return true;
    }

    default boolean onPostEvent(Object interceptorAttr) {
        return true;
    }

    void onSubscriberProcess(Class clz, Method method, Object ob);

}
