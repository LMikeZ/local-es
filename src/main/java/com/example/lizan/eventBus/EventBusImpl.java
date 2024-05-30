package com.example.lizan.eventBus;

import com.example.lizan.eventBus.exception.EventExceptionWrapper;
import com.example.lizan.eventBus.handler.DispatchHandler;
import com.example.lizan.eventBus.parse.MsgDeserialize;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 16:31
 * @Description TODO
 */
public class EventBusImpl implements EventBus, ApplicationContextAware {

    private MsgDeserialize msgProcess;
    private DispatchHandler dispatchHandler;

    public EventBusImpl(MsgDeserialize msgDeserialize, DispatchHandler dispatchHandler) {
        this.msgProcess = msgDeserialize;
        this.dispatchHandler = dispatchHandler;
    }

    /**
     * 远端固定数据结构 仅支持单个消费者
     *
     * @param channel
     * @param bodyData
     */
    @Override
    public void dispatchEvent(String channel, String bodyData) throws Throwable {
        try {
            IMessage message = msgProcess.parseData(bodyData, name -> dispatchHandler.hasEventSubscriber(name));
            if (message != null) {
                dispatchHandler.dispatchEvent(message);
            }
        } catch (EventExceptionWrapper e) {
            dispatchHandler.dispatchEventException(e);
        } catch (Throwable throwable) {
            dispatchHandler.dispatchEventException(new EventExceptionWrapper(null, throwable, null));
        }
    }

    @Override
    public void dispatchEvent(IMessage message) {
        if (message != null) {
            msgProcess.initMsgCtxHeadForMsg(message);
            dispatchHandler.dispatchEvent(message);
        }
    }

    /**
     * 本地转发 订阅 支持多个消费者
     *
     * @param object
     */
    @Override
    public void dispatchSubscriber(Object object) {
        dispatchHandler.dispatchSubscriber(object);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
