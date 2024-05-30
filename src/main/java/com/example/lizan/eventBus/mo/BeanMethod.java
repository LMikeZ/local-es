package com.example.lizan.eventBus.mo;

import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 14:05
 * @Description TODO
 */
@Data
@AllArgsConstructor
public class BeanMethod {
    private String beanName;
    private Method method;
    private int heardIndex;
    private int valueIndex;
    private int argSize;
    private String[] argsName;
}
