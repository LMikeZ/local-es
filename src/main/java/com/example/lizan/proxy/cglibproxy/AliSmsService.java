package com.example.lizan.proxy.cglibproxy;

/**
 * @author lizan
 * @version $Id: AliSmsService.java, v 0.1 2022年06月13日 16:10 lizan Exp $$
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}