package com.example.lizan.handler;

import com.example.lizan.req.CompleteTaskReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 办结中心模板
 * @author lizan
 * @version $Id: CloseProcessTemplate.java, v 0.1 2022年05月13日 10:40 lizan Exp $$
 */
@Slf4j
@Component
public class CloseProcessTemplate extends AbstractDefaultProcessTemplate {

    @Override
    protected void operateRecords(CompleteTaskReq req) {

    }
}