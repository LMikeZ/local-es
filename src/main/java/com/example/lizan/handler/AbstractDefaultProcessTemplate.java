package com.example.lizan.handler;

import com.example.lizan.req.CompleteTaskReq;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认抽象模板
 * @author lizan
 * @version $Id: AbstractDefaultProcessTemplate.java, v 0.1 2022年05月13日 10:38 lizan Exp $$
 */
@Slf4j
public abstract class AbstractDefaultProcessTemplate implements ProcessOperateHandler{


    @Override
    public void operate(CompleteTaskReq req){

        //操作记录
        operateRecords(req);

        //完成任务接口
        completeTask(req);
        
    }

    protected abstract void operateRecords(CompleteTaskReq req);

    private void completeTask(CompleteTaskReq req) {

    }


}
