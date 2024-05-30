package com.example.lizan.eventBus.parse.deserialize;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.anno.MessageTag;
import com.example.lizan.eventBus.parse.DeserializeInfo;
import com.alibaba.fastjson.JSONObject;

public interface IDeserialize<T extends IMessage> {
    T deserializeData(DeserializeInfo deserializeInfo) throws Exception;
}
