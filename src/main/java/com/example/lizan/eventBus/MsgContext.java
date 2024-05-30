package com.example.lizan.eventBus;

import lombok.Data;

@Data
public class MsgContext {

    private MessageHeader header;

    protected static final ThreadLocal<? extends MsgContext> threadLocal = ThreadLocal.withInitial(() -> {
        try {
            return new MsgContext();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    });

    private MsgContext() {

    }

    public static MsgContext get() {
        return threadLocal.get();
    }

    public void destroy() {
        threadLocal.remove();
    }
}
