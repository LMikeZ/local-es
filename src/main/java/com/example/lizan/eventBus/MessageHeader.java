package com.example.lizan.eventBus;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MessageHeader {
    private String name;
    private String meetingId;
    private String userId;
    private Long timestamp;
    private String connectionId;
    private String voiceConf;
    private String host;
}
