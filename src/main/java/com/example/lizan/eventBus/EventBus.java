package com.example.lizan.eventBus;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 16:28
 * @Description TODO
 */
public interface EventBus {

    /**
     * 远端固定数据结构 仅支持单个消费者
     *
     * @param channel
     * @param bodyData
     */
    void dispatchEvent(String channel, String bodyData) throws Throwable;


    void dispatchEvent(IMessage message);

    /**
     * 本地转发 订阅 支持多个消费者
     *
     * @param object
     */
    void dispatchSubscriber(Object object);
}
