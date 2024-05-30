package com.example.lizan.eventBus.parse.serialize;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MsgContext;
import com.example.lizan.eventBus.anno.MessageTag;
import com.example.lizan.eventBus.config.EventBusConfig;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;

import javax.sql.rowset.serial.SerialException;

public class DefaultSerialize<T extends IMessage> implements ISerialize<T> {

    @Override
    public JSONObject serializeEnvelope(T t, EventBusConfig eventBusConfig) throws SerialException {
        JSONObject envelopeJsonObject = new JSONObject();
        JSONObject routingJsonObject = new JSONObject();
        envelopeJsonObject.put("timestamp", System.currentTimeMillis());
        envelopeJsonObject.put("host",eventBusConfig.getServerHost());
        MessageTag annotation = t.getClass().getAnnotation(MessageTag.class);
        String name = annotation.value();
        envelopeJsonObject.put("name", name);
        routingJsonObject.put("sender", StringUtils.isEmpty(annotation.sender()) ? eventBusConfig.getDefaultSender() : annotation.sender());
        if (StringUtils.isNotEmpty(t.headerMeetingId())) {
            routingJsonObject.put("meetingId", t.headerMeetingId());
        }
        if (StringUtils.isNotEmpty(t.headerUserId())) {
            routingJsonObject.put("userId", t.headerUserId());
        }
        if (StringUtils.isNotEmpty(annotation.msgType())) {
            routingJsonObject.put("msgType", StringUtils.isEmpty(annotation.msgType()) ? eventBusConfig.getDefaultMsgType() : annotation.msgType());
        }
        envelopeJsonObject.put("routing", routingJsonObject);
        return envelopeJsonObject;
    }

    @Override
    public JSONObject serializeHead(T t) throws SerialException {
        MessageTag annotation = t.getClass().getAnnotation(MessageTag.class);
        JSONObject head = new JSONObject();
        head.put("name", annotation.value());
        if (StringUtils.isNotEmpty(t.headerMeetingId())) {
            head.put("meetingId", t.headerMeetingId());
        } else if (MsgContext.get().getHeader() != null && StringUtils.isNotEmpty(MsgContext.get().getHeader().getMeetingId())) {
            head.put("meetingId", MsgContext.get().getHeader().getMeetingId());
        }
        if (StringUtils.isNotEmpty(t.headerUserId())) {
            head.put("userId", t.headerUserId());
        }
        return head;
    }

    @Override
    public JSONObject serializeBody(T t) throws SerialException {
        return JSONObject.parseObject(JSONObject.toJSONString(t));
    }

}
