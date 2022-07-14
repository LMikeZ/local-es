package com.example.lizan;

import com.example.lizan.proxy.SmsService;
import com.example.lizan.proxy.SmsServiceImpl;
import com.example.lizan.proxy.cglibproxy.AliSmsService;
import com.example.lizan.proxy.cglibproxy.CglibProxyFactory;
import com.example.lizan.proxy.jdkproxy.JdkProxyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizan
 * @version $Id: ProxyTest.java, v 0.1 2022年06月13日 15:56 lizan Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class ProxyTest {


    @Test
    public void testJdk(){
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
    @Test
    public void testCglib(){
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}