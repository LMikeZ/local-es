package com.example.lizan.eventBus;


public interface MessageService {

    void sendMessage(String exchange, String channel, Object data);

    void sendMessage(String channel, IMessage msg);

    void sendMessage(String channel, String msg);

    void sendMessage(String exchange, String channel, String data);

    void sendMessage(IMessage message);

}
