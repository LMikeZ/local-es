package com.example.lizan.controller;

import com.alibaba.fastjson.JSON;
import com.example.lizan.repository.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author lizan
 * @version $Id: KafkaController.java, v 0.1 2022年07月15日 14:38 lizan Exp $$
 */
@RestController("kafka")
public class KafkaController {
    private final static String TOPIC_NAME = "my-replicated-topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public void send() {
        TestUser user = new TestUser();
        user.setId(1L);
        user.setName("刘书豪");
        user.setSex("女");
        user.setPassword("12345");
        user.setGmtCreate(LocalDateTime.now());
        kafkaTemplate.send(TOPIC_NAME, "key", JSON.toJSONString(user));
    }
}