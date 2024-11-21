package com.example.lizan.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lizan
 * @version $Id: ErpResult.java, v 0.1 2024年06月11日 13:07 lizan Exp $$
 */
@Data
@AllArgsConstructor
public class ErpResult {


    /**
     * OperateTimes : 2024/6/11 9:30:23
     * Message : 保存成功，返回的ID：102692，单据号为YTJM24060160
     * Data : YTJM24060160
     * Result : true
     */
    @JsonProperty("OperateTimes")
    private String OperateTimes;
    @JsonProperty( "Message")
    private String Message;
    @JsonProperty( "Data")
    private String Data;
    @JsonProperty( "Result")
    private boolean Result;
}
