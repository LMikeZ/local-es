package com.example.lizan.eventBus.mo;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MessageHeader;

import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-25 17:02
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterceptorAttr {
    private IMessage message;
    private Object bean;
    private Method method;
    private Object[] args;
    private String[] argsName;
    private MessageHeader header;
}
