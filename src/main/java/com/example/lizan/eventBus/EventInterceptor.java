package com.example.lizan.eventBus;

import com.example.lizan.eventBus.mo.BeanMethod;
import com.example.lizan.eventBus.mo.InterceptorAttr;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 11:48
 * @Description 事件拦截器
 */
public interface EventInterceptor {

    int order();


    default boolean onPreMessage(InterceptorAttr interceptorAttr) {
        return true;
    }

    default boolean onPostMessage(InterceptorAttr interceptorAttr) {
        return true;
    }

}
