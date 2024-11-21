package com.example.lizan.design.strategy;

import com.example.lizan.enums.TaskTypeEnum;
import com.example.lizan.req.CompleteTaskReq;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 策略模板工厂
 *
 * @author lizan
 * @version $Id: EventTaskTypeFactory.java, v 0.1 2022年01月26日 14:23 lizan Exp $$
 */
@Component
public class EventTaskTypeFactory {


    @Autowired
    private TreatProcessTemplate treatProcessTemplate;
    @Autowired
    private DispatchProcessTemplate dispatchProcessTemplate;
    @Autowired
    private AuditProcessTemplate auditProcessTemplate;
    @Autowired
    private AcceptProcessTemplate acceptProcessTemplate;
    @Autowired
    private CloseProcessTemplate closeProcessTemplate;

    @Autowired
    private List<ProcessOperateHandler> processOperateHandlers;

    private static HashMap<String, ProcessOperateHandler> handlerHashMap = new HashMap<>();

    @PostConstruct
    private void initHandlerMap() {
        // 类型分类的handler
        // if (MapUtils.isEmpty(handlerHashMap)) {
        //     handlerHashMap.put(TaskTypeEnum.ACCEPT.getType(), acceptProcessTemplate);
        //     handlerHashMap.put(TaskTypeEnum.DISPATCH.getType(), dispatchProcessTemplate);
        //     handlerHashMap.put(TaskTypeEnum.AUDIT.getType(), auditProcessTemplate);
        //     handlerHashMap.put(TaskTypeEnum.TREAT.getType(), treatProcessTemplate);
        //     handlerHashMap.put(TaskTypeEnum.CLOSE.getType(), closeProcessTemplate);
        //
        // }
        processOperateHandlers.stream().filter(k -> StringUtils.isNotBlank(k.getType())).forEach(x -> {
            handlerHashMap.put(x.getType(), x);
        });

    }

    public static ProcessOperateHandler getHandler(String type) {
        ProcessOperateHandler taskTypeHandler = handlerHashMap.get(type);
        if (Objects.nonNull(taskTypeHandler)) {
            return taskTypeHandler;
        }
        return null;
    }


}