package com.example.lizan.eventBus.exception;

import com.example.lizan.eventBus.IMessage;
import com.example.lizan.eventBus.MessageHeader;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-27 16:42
 * @Description TODO
 */

public class EventExceptionWrapper extends RuntimeException {
    private IMessage targetMessage;
    private Throwable target;
    private MessageHeader messageHeader;

    public EventExceptionWrapper(IMessage targetMessage, Throwable target, MessageHeader messageHeader) {
        this.targetMessage = targetMessage;
        this.target = target;
        this.messageHeader = messageHeader;
    }

    public IMessage getTargetMessage() {
        return targetMessage;
    }

    public void setTargetMessage(IMessage targetMessage) {
        this.targetMessage = targetMessage;
    }

    public Throwable getTarget() {
        return target;
    }

    public void setTarget(Throwable target) {
        this.target = target;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }
}
