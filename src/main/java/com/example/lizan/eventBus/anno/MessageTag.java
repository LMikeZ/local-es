package com.example.lizan.eventBus.anno;


import com.example.lizan.eventBus.MessageHeader;
import com.example.lizan.eventBus.parse.deserialize.DefaultDeserialize;
import com.example.lizan.eventBus.parse.deserialize.IDeserialize;
import com.example.lizan.eventBus.parse.serialize.DefaultSerialize;
import com.example.lizan.eventBus.parse.serialize.ISerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
/**
 * @see   com.example.lizan.eventBus.config.EventBusConfig defaultData
 */
public @interface MessageTag {
    String value() default "";

    String sendChannel() default "";

    String sender() default "";

    String msgType() default "";

    String exchange() default "";

    Class<? extends MessageHeader> header() default MessageHeader.class;

    Class<? extends ISerialize> serializeUsing() default DefaultSerialize.class;

    Class<? extends IDeserialize> deserializeUsing() default DefaultDeserialize.class;
}
