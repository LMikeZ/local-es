package com.example.lizan.spring;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author lizan
 * @version $Id: SpringUtils.java, v 0.1 2023年03月24日 13:50 lizan Exp $$
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    @Getter
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
//
//    public ApplicationContext getContext() {
//        return context;
//    }
}
