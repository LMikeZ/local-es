package com.example.lizan.eventBus.handler;

import com.example.lizan.eventBus.EventInterceptor;
import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MessageHeader;
import com.example.lizan.eventBus.mo.BeanMethod;
import com.example.lizan.eventBus.mo.InterceptorAttr;
import com.example.lizan.eventBus.subscriber.SubscriberInterceptor;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 16:48
 * @Description TODO
 */
@Slf4j
public class InterceptorHandler {

    private List<EventInterceptor> interceptors = new ArrayList<>();

    private List<SubscriberInterceptor> subscriberInterceptors = new ArrayList<>();

    final Comparator<SubscriberInterceptor> comparatorSubscriberInterceptor = (o1, o2) -> Integer.compare(o1.order(), o2.order());

    final Comparator<EventInterceptor> comparatorMessageInterceptor = (o1, o2) -> Integer.compare(o1.order(), o2.order());

    public void addInterceptor(EventInterceptor bean) {
        interceptors.add(bean);
        Collections.sort(interceptors, comparatorMessageInterceptor);
    }

    public boolean hasInterceptors() {
        return !CollectionUtils.isEmpty(interceptors);
    }

    public boolean disPatchStart(InterceptorAttr interceptorAttr) {
        for (EventInterceptor interceptor : interceptors) {
            if (!interceptor.onPreMessage(interceptorAttr)) {
                log.debug("onPreMessage eventInterceptor {} return false", interceptor.getClass().getName());
                return false;
            }
        }
        return true;
    }

    public boolean disPatchEnd(InterceptorAttr interceptorAttr) {
        for (EventInterceptor interceptor : interceptors) {
            if (!interceptor.onPostMessage(interceptorAttr)) {
                log.debug("onPostMessage eventInterceptor {} return false", interceptor.getClass().getName());
                return false;
            }
        }
        return true;
    }

    public boolean disPatchSubscriberStart(Object o) {
        for (SubscriberInterceptor interceptor : subscriberInterceptors) {
            if (!interceptor.onPreEvent(o)) {
                log.debug("onPreMessage eventInterceptor {} return false", interceptor.getClass().getName());
                return false;
            }
        }
        return true;
    }

    public boolean disPatchSubscriberEnd(Object o) {
        for (SubscriberInterceptor interceptor : subscriberInterceptors) {
            if (!interceptor.onPostEvent(o)) {
                log.debug("onPreMessage eventInterceptor {} return false", interceptor.getClass().getName());
                return false;
            }
        }
        return true;
    }

    public void disPatchProcessItem(Class<?> aClass, Method method, Object object) {
        for (SubscriberInterceptor interceptor : subscriberInterceptors) {
            interceptor.onSubscriberProcess(aClass, method, object);
        }
    }

    public boolean hasSubscriberInterceptor() {
        return !CollectionUtils.isEmpty(subscriberInterceptors);
    }

    public void addSubscriberInterceptor(SubscriberInterceptor bean) {
        subscriberInterceptors.add(bean);
        Collections.sort(subscriberInterceptors, comparatorSubscriberInterceptor);
    }


}
