package com.example.lizan.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author lizan
 * @version $Id: KafkaListener.java, v 0.1 2022年07月15日 14:43 lizan Exp $$
 */
@Component
@Slf4j
public class KafkaListenerMQ {



    @KafkaListener(topics = "my-replicated-topic", groupId = "uti-flow-message")
    public void handleProcessAuditMessage(ConsumerRecord record, Acknowledgment acknowledgment) {
        try {
            String message = (String) record.value();
            System.out.println(message);
        } catch (Exception e) {
            log.error("[handleProcessAuditMessage] 处理消息异常:{}", e.getMessage(), e);
        } finally {
            // 手动提交 offset
            acknowledgment.acknowledge();
        }
    }
}