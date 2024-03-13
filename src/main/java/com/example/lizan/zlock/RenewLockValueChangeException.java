package com.example.lizan.zlock;

import java.io.IOException;

/**
 * @projectName: abcpen-springboot
 * @className: RenewLockErrorException
 * @author: ZhaoCheng
 * @description:
 * @date: 2022/11/29 7:14 PM
 * @version: 1.0
 */
public class RenewLockValueChangeException extends IOException {

    private String key;
    public RenewLockValueChangeException(String message) {
        super(message);
        this.key = message;
    }

    public String getKey() {
        return key;
    }
}
