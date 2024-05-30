package com.example.lizan.eventBus.parse.deserialize;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MessageHeader;
import com.example.lizan.eventBus.MsgContext;
import com.example.lizan.eventBus.parse.DeserializeInfo;

import java.lang.reflect.Type;

public class DefaultDeserialize<T extends IMessage> implements IDeserialize<T> {


    @Override
    public T deserializeData(DeserializeInfo deserializeInfo) {
        T t = deserializeInfo.getBody().toJavaObject((Type) deserializeInfo.getMsgClass());
        Class<? extends MessageHeader> header = deserializeInfo.getAnnotation().header();
        MessageHeader messageHeader = deserializeInfo.getHeader().toJavaObject(header);
        Long timestamp = deserializeInfo.getEnvelopeJson().getLong("timestamp");
        String host = deserializeInfo.getEnvelopeJson().getString("host");
        messageHeader.setTimestamp(timestamp);
        messageHeader.setHost(host);
        MsgContext.get().setHeader(messageHeader);
        return t;
    }
}
