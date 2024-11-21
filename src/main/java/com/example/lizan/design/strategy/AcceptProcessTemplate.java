package com.example.lizan.design.strategy;

import com.example.lizan.enums.TaskTypeEnum;
import com.example.lizan.req.CompleteTaskReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 受理中心
 * @author lizan
 * @version $Id: AcceptProcessTemplate.java, v 0.1 2022年05月13日 10:37 lizan Exp $$
 */
@Slf4j
@Component
public class AcceptProcessTemplate extends AbstractDefaultProcessTemplate {
    @Override
    protected void operateRecords(CompleteTaskReq req) {
        System.out.println("接收---");
    }

    @Override
    public String getType() {
        return TaskTypeEnum.ACCEPT.getType();
    }
}