package com.example.lizan.spring.selftag;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author lizan
 * @version $Id: UserBeanDefinitionParser.java, v 0.1 2023年03月20日 14:54 lizan Exp $$
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String age = element.getAttribute("age");
        if (StringUtils.isNotBlank(userName)) {
            builder.addPropertyValue("userName", userName);
        }
        if (StringUtils.isNotBlank(age)) {
            builder.addPropertyValue("age", age);
        }

    }
}
