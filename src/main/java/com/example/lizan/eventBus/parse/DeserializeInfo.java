package com.example.lizan.eventBus.parse;

import com.example.lizan.eventBus.anno.MessageTag;
import com.alibaba.fastjson.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-22 16:42
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeserializeInfo {
    private String envelope;
    private JSONObject header;
    private JSONObject body;
    private JSONObject envelopeJson;
    private MessageTag annotation;
    private Class<?> msgClass;


}
