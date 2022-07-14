package com.example.lizan.proxy;

/**
 * @author lizan
 * @version $Id: SmsServiceImpl.java, v 0.1 2022年06月13日 15:52 lizan Exp $$
 */

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}