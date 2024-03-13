package com.example.lizan.spring.myprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author lizan
 * @version $Id: MyBeanFactoryProcessor.java, v 0.1 2023年03月29日 16:19 lizan Exp $$
 */
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("j----------------- ");
    }
}
