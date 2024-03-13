package com.example.lizan.spring;

import com.alibaba.fastjson.JSON;
import com.example.lizan.spring.selftag.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lizan
 * @version $Id: SpringDemo.java, v 0.1 2023年01月30日 10:14 lizan Exp $$
 */
public class SpringDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-spring.xml");
//        SpringDemo2 springDemo2 = classPathXmlApplicationContext.getBean(SpringDemo2.class);
//        User bean = SpringUtils.getContext().getBean(User.class);
//        bean.setAge("11");
//        System.out.println(JSON.toJSONString(bean));
    }
}
