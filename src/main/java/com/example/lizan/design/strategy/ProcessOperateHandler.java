package com.example.lizan.design.strategy;


import com.example.lizan.req.CompleteTaskReq;

/**
 * @author lizan
 * @version $Id: EventTaskTypeHandler.java, v 0.1 2022年01月26日 14:23 lizan Exp $$
 */
public interface ProcessOperateHandler {


     void operate(CompleteTaskReq req);
     String getType();
}