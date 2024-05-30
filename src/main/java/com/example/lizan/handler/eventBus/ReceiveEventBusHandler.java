package com.example.lizan.handler.eventBus;

import com.alibaba.fastjson.JSON;
import com.example.lizan.bean.UserTestDTO;
import com.example.lizan.eventBus.anno.Schedule;
import com.example.lizan.eventBus.anno.Subscriber;
import org.springframework.stereotype.Component;

/**
 * @author lizan
 * @version $Id: ReceiveEventBusHandler.java, v 0.1 2024年05月30日 15:15 lizan Exp $$
 */
@Component
public class ReceiveEventBusHandler {


    @Subscriber(schedule = Schedule.WORK)
    public void receive(UserTestDTO msg) {
        System.out.println("ReceiveEventBusHandler receive msg:" + JSON.toJSONString(msg));
    }
}
