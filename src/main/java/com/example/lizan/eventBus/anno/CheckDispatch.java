package com.example.lizan.eventBus.anno;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-24 17:00
 * @Description TODO
 */
@FunctionalInterface
public interface CheckDispatch {
    boolean hasEventSubscriber(String name);
}
