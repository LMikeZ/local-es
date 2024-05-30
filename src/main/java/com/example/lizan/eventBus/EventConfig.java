package com.example.lizan.eventBus;

import com.example.lizan.eventBus.anno.EventBusRegister;
import com.example.lizan.eventBus.config.EventBusConfig;
import com.example.lizan.eventBus.handler.DispatchHandler;
import com.example.lizan.eventBus.handler.InterceptorHandler;
import com.example.lizan.eventBus.handler.MessageConfig;
import com.example.lizan.eventBus.parse.MsgDeserialize;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@EnableConfigurationProperties(EventBusConfig.class)
public class EventConfig {

    @Bean
    public InterceptorHandler interceptorHandler() {
        return new InterceptorHandler();
    }

    @Bean
    public DispatchHandler dispatchHandler(InterceptorHandler interceptorHandler) {
        return new DispatchHandler(interceptorHandler);
    }

    @Bean
    public MessageConfig msgConfig() {
        return new MessageConfig();
    }

    @Bean
    public EventBusRegister eventProcessor(MessageConfig recMsgConfig, InterceptorHandler interceptorHandler, DispatchHandler dispatchHandler) {
        return new EventBusRegister(recMsgConfig, dispatchHandler, interceptorHandler);
    }

    @Primary
    @Bean
    public MsgDeserialize msgProcess(MessageConfig messageHandler) {
        return new MsgDeserialize(messageHandler);
    }

    @Bean
    @ConditionalOnMissingBean
    public EventBus eventBus(MsgDeserialize msgProcess, DispatchHandler dispatchHandler) {
        return new EventBusImpl(msgProcess, dispatchHandler);
    }
}
