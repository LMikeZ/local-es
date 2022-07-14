package com.example.lizan.kafka.producer;

/**
 * @author lizan
 * @version $Id: MyProducer.java, v 0.1 2022年07月14日 10:30 lizan Exp $$
 */

import com.alibaba.fastjson.JSON;
import com.example.lizan.repository.model.TestUser;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

//消息的发送方
public class MyProducer {

    private final static String TOPIC_NAME = "my-replicated-topic";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.10.158:19092,10.0.10.158:29092,10.0.10.158:39092");
//把发送的key从字符串序列化为字节数组
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//把发送消息value从字符串序列化为字节数组
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        TestUser user = new TestUser();
        user.setId(1L);
        user.setName("刘书豪");
        user.setSex("女");
        user.setPassword("12345");
        user.setGmtCreate(LocalDateTime.now());
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME, user.getId().toString(), JSON.toJSONString(user));
        //=====阻塞=======  同步
        RecordMetadata metadata = producer.send(producerRecord).get();
        System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-" + metadata.partition() + "|offset-" + metadata.offset());

        //异步发送
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception != null) {
                    System.err.println("发送消息失败：" +
                            exception.getStackTrace());
                }
                if (metadata != null) {
                    System.out.println("异步方式发送消息结果：" + "topic-" +metadata.topic() + "|partition-"+ metadata.partition() + "|offset-" + metadata.offset());
                }
            }
        });
    }
}