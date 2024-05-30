package com.example.lizan.eventBus;


public interface IMessage {

    default String headerMeetingId() {
        return null;
    }

    default String headerUserId() {
        return null;
    }

}
