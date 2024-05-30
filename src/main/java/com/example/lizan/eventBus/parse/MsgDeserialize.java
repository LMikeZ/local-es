package com.example.lizan.eventBus.parse;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MessageHeader;
import com.example.lizan.eventBus.MsgContext;
import com.example.lizan.eventBus.anno.CheckDispatch;
import com.example.lizan.eventBus.anno.MessageTag;
import com.example.lizan.eventBus.handler.MessageConfig;
import com.example.lizan.eventBus.parse.deserialize.DefaultDeserialize;
import com.example.lizan.eventBus.parse.deserialize.IDeserialize;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class MsgDeserialize implements ApplicationContextAware {

    private MessageConfig messageTagConfig;

    private IDeserialize defaultDeserialize = new DefaultDeserialize();

    public MsgDeserialize(MessageConfig messageTagConfig) {
        this.messageTagConfig = messageTagConfig;
    }

    public IMessage parseData(String bodyData, CheckDispatch checkDispatch) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(bodyData);
        if (jsonObject.containsKey("envelope")) {
            JSONObject envelope = jsonObject.getJSONObject("envelope");
            String name = envelope.getString("name");
            if (checkDispatch.hasEventSubscriber(name)) {
                Class msgClass = messageTagConfig.getMsgClassMap().get(name);
                MessageTag annotation = (MessageTag) msgClass.getAnnotation(MessageTag.class);
                return processMsg(name, msgClass, jsonObject, envelope, annotation);
            }
        }
        return null;
    }

    private IMessage processMsg(String name, Class msgClass, JSONObject jsonObject, JSONObject envelope, MessageTag annotation) throws Exception {
        JSONObject core = jsonObject.getJSONObject("core");
        JSONObject header = core.getJSONObject("header");
        JSONObject body = core.getJSONObject("body");
        Class<? extends IDeserialize> aClass = annotation.deserializeUsing();
        IDeserialize iSerialize = defaultDeserialize;
        if (aClass != DefaultDeserialize.class) {
            iSerialize = aClass.newInstance();
        }
        IMessage o = iSerialize.deserializeData(new DeserializeInfo(name, header, body, envelope, annotation, msgClass));
        return o;
    }


    public void initMsgCtxHeadForMsg(IMessage message) {
        MessageTag annotation = message.getClass().getAnnotation(MessageTag.class);
        String meetingId = message.headerMeetingId();
        String userId = message.headerUserId();
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setMeetingId(meetingId);
        messageHeader.setUserId(userId);
        messageHeader.setName(annotation.value());
        messageHeader.setTimestamp(System.currentTimeMillis());
        MsgContext.get().setHeader(messageHeader);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
