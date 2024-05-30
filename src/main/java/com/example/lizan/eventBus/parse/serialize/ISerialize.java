package com.example.lizan.eventBus.parse.serialize;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.config.EventBusConfig;
import com.alibaba.fastjson.JSONObject;

import javax.sql.rowset.serial.SerialException;

public interface ISerialize<T extends IMessage> {

    JSONObject serializeEnvelope(T t, EventBusConfig eventBusConfig) throws SerialException;

    JSONObject serializeHead(T t) throws SerialException;

    JSONObject serializeBody(T t) throws SerialException;
}
