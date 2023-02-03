package com.example.lizan.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lizan
 * @version $Id: SpringDemo.java, v 0.1 2023年01月30日 10:14 lizan Exp $$
 */
public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspects.xml", "daos.xml", "services.xml");

    }
}
