package com.example.lizan.eventBus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-28 20:56
 * @Description TODO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "eventbus")
public class EventBusConfig {
    private String defaultSendChannel;
    private String defaultSender;
    private String defaultMsgType;
    private String defaultExchange;
    private String serverHost;
}
