package com.example.lizan.eventBus.anno;

import com.example.lizan.eventBus.EventInterceptor;
import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.handler.DispatchHandler;
import com.example.lizan.eventBus.handler.InterceptorHandler;
import com.example.lizan.eventBus.handler.MessageConfig;
import com.example.lizan.eventBus.subscriber.SubscriberInterceptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;


public class EventBusRegister implements BeanPostProcessor {


    private DispatchHandler dispatchHandler;
    private InterceptorHandler interceptorHandler;
    private MessageConfig messageConfig;

    public EventBusRegister(MessageConfig messageConfig, DispatchHandler dispatchHandler, InterceptorHandler interceptorHandler) {
        this.dispatchHandler = dispatchHandler;
        this.interceptorHandler = interceptorHandler;
        this.messageConfig = messageConfig;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(com.example.lizan.eventBus.anno.OnEventInterceptor.class) || bean.getClass().isAnnotationPresent(com.example.lizan.eventBus.anno.OnSubscriberInterceptor.class)) {
            addEventInterceptor(bean);
        }
        ReflectionUtils.doWithMethods(bean.getClass(),
                method -> {
                    if (method.isAnnotationPresent(com.example.lizan.eventBus.anno.OnEvent.class)) {
                        processEventMethod(method, beanName);
                    }

                    if (method.isAnnotationPresent(Subscriber.class)) {
                        processSubscriberMethod(method, beanName);
                    }

                    if (method.isAnnotationPresent(com.example.lizan.eventBus.anno.OnEventException.class)){
                        processExceptionHandler(method,beanName);
                    }
                });

        return bean;
    }



    private void addEventInterceptor(Object bean) {
        boolean isAttach = false;
        if (EventInterceptor.class.isAssignableFrom(bean.getClass())) {
            interceptorHandler.addInterceptor((EventInterceptor) bean);
            isAttach = true;
        }

        if (SubscriberInterceptor.class.isAssignableFrom(bean.getClass())) {
            interceptorHandler.addSubscriberInterceptor((SubscriberInterceptor) bean);
            isAttach = true;
        }

        if (!isAttach){
            throw new RuntimeException(String.format("%s OnEventInterceptor must implements EventInterceptor", bean.getClass().getName()));

        }
    }

    private void processEventMethod(Method method, String beanName) {
        com.example.lizan.eventBus.anno.OnEvent annotation = method.getAnnotation(com.example.lizan.eventBus.anno.OnEvent.class);
        String eventName = annotation.value();
        if (StringUtils.isEmpty(eventName)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                boolean assignableFrom = IMessage.class.isAssignableFrom(parameterType);
                if (assignableFrom) {
                    MessageTag messageTag = parameterType.getAnnotation(MessageTag.class);
                    eventName = messageTag.value();
                }
            }
        }

        if (StringUtils.isEmpty(eventName)) {
            throw new RuntimeException("eventName is empty " + method.getName());
        }
        Map<String, Class> eventNameMap = messageConfig.getEventNameMap();
        if (eventNameMap.containsKey(eventName)) {
            dispatchHandler.addEventMethod(eventName, beanName, method);
        }
    }


    private void processSubscriberMethod(Method method, String beanName) {
        Subscriber subscriber = method.getAnnotation(Subscriber.class);
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length > 1) {
            throw new RuntimeException(String.format(" %s method args must one class ", method.getName()));
        }
        dispatchHandler.addSubscriber(beanName, method,parameterTypes[0]);

    }


    private void processExceptionHandler(Method method, String beanName) {
        com.example.lizan.eventBus.anno.OnEventException annotation = method.getAnnotation(com.example.lizan.eventBus.anno.OnEventException.class);
        Class<? extends Throwable>[] value = annotation.value();
        dispatchHandler.addExceptionHandler(beanName,method,value);
    }

}
