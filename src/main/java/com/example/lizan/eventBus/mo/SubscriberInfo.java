package com.example.lizan.eventBus.mo;

import com.example.lizan.eventBus.anno.Subscriber;

import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 17:30
 * @Description TODO
 */
@Data
@AllArgsConstructor
public class SubscriberInfo {
    private String beanName;
    private Method method;
    private Subscriber subscriber;
}
