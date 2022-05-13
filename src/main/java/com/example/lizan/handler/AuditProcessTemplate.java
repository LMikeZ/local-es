package com.example.lizan.handler;

import com.example.lizan.req.CompleteTaskReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 审核中心模板
 * @author lizan
 * @version $Id: AuditProcessTemplate.java, v 0.1 2022年05月13日 10:38 lizan Exp $$
 */
@Component
@Slf4j
public class AuditProcessTemplate extends AbstractDefaultProcessTemplate {

    @Override
    protected void operateRecords(CompleteTaskReq req) {

    }
}