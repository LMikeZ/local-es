package com.example.lizan.spring.selftag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author lizan
 * @version $Id: UserNamespaceHandler.java, v 0.1 2023年03月24日 14:25 lizan Exp $$
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());

    }
}
