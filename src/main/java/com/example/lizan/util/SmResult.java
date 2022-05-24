package com.example.lizan.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmResult<T> implements Serializable {
    private boolean success;
    private String msg;
    private T data;
    private int code;

    public SmResult() {
        this.msg = "";
        this.code = 200;
    }

    public SmResult(boolean isSuccess) {
        this.msg = "";
        this.code = 200;
        this.success = isSuccess;
    }

    public SmResult(boolean isSuccess, String msg) {
        this(isSuccess);
        this.msg = msg;
    }

    public SmResult(boolean isSuccess, T data) {
        this(isSuccess);
        this.data = data;
    }

    public SmResult(boolean isSuccess, T data, String msg) {
        this(isSuccess, data);
        this.msg = msg;
    }

    public static SmResult instance() {
        return new SmResult();
    }

    public SmResult success(boolean isSuccess) {
        this.success = isSuccess;
        return this;
    }

    public SmResult msg(String msg) {
        this.msg = msg;
        return this;
    }

    public SmResult data(T data) {
        this.data = data;
        return this;
    }

    public SmResult code(int code) {
        this.code = code;
        return this;
    }

    public static SmResult data(List list, int count) {
        Map<String, Object> map = new HashMap(2);
        map.put("list", list);
        map.put("count", count);
        return instance().success(true).data(map);
    }

    public static SmResult data(List list, Long count) {
        Map<String, Object> map = new HashMap(2);
        map.put("list", list);
        map.put("count", count);
        return instance().success(true).data(map);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static SmResult fail(int code) {
        return instance().success(false).code(code);
    }

    public static SmResult fail(String msg) {
        return instance().success(false).msg(msg);
    }

    public static SmResult fail(int code, String msg) {
        return instance().success(false).code(code).msg(msg);
    }

    public static SmResult ok() {
        return instance().success(true);
    }

    public static SmResult ok(Object data) {
        return instance().success(true).data(data);
    }
}
