package com.example.lizan.eventBus.mo;

import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaocheng
 * @version 1.0.0
 * @createDate 2020-07-27 16:38
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionHandlerInfo {
    private String beanName;
    private Method method;

    @Builder.Default
    private int iMsgIndex = -1;
    @Builder.Default
    private int iHeadIndex = -1;
    @Builder.Default
    private int exceptionIndex = -1;
}
