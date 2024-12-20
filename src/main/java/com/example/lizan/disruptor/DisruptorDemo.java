package com.example.lizan.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.Executors;

@Slf4j
public class DisruptorDemo {
    public static void main(String[] args) throws InterruptedException {
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                OrderEvent::new,
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );
        disruptor.handleEventsWith(new OrderEventHandler());
        disruptor.start();
        for (int i = 0; i < 100; i++) {
            RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
            OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
            eventProducer.onData(i+"_"+UUID.randomUUID().toString());
        }

    }
}
