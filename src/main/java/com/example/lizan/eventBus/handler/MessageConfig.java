package com.example.lizan.eventBus.handler;


import com.example.lizan.eventBus.EventInterceptor;
import com.example.lizan.eventBus.anno.MessageScanner;
import com.example.lizan.eventBus.anno.MessageTag;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageConfig implements ApplicationContextAware {

    private Map<String, Class> msgClassMap = new HashMap<>();

    private Map<String, Class> eventNameMap = new HashMap<>();

    public Map<String, Class> getMsgClassMap() {
        return msgClassMap;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MessageScanner messageScanner = new MessageScanner(applicationContext);
        try {
            Set<Class<?>> scan = messageScanner.scan(MessageTag.class);
            scan.forEach(aClass -> {
                MessageTag annotation = aClass.getAnnotation(MessageTag.class);
                if (eventNameMap.containsKey(annotation.value())){
                    throw new RuntimeException(String.format("eventName duplicate class %s %s",eventNameMap.get(annotation.value()).getSimpleName(),aClass.getSimpleName()));
                }
                msgClassMap.put(annotation.value(), aClass);
                String eventName = annotation.value();
                eventNameMap.put(eventName, aClass);
            });
            log.debug("input message {}", msgClassMap);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Class> getEventNameMap() {
        return eventNameMap;
    }


}
