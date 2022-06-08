package com.example.lizan.error;

/**
 * @author lizan
 * @version $Id: ErrorInfo.java, v 0.1 2022年06月08日 9:54 lizan Exp $$
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorInfo {
    private final long code;
    private final String name;
    public static final Integer DEFAULT_ERROR_CODE = -500;
    @JsonIgnore
    private String msg;

    public ErrorInfo(ErrorInfo errorInfo) {
        this(errorInfo.getCode(), errorInfo.getName());
    }

    public ErrorInfo(ErrorInfo errorInfo, String msg) {
        this(errorInfo.getCode(), errorInfo.getName(), msg);
    }

    public ErrorInfo(long code, String name) {
        this.code = code;
        this.name = name;
    }

    public ErrorInfo(long code, String name, String msg) {
        this(code, name);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Error Code(" + this.code + ") Name:" + this.name + " Msg:" + this.msg;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ErrorInfo)) {
            return false;
        } else {
            return this.code == ((ErrorInfo) o).getCode();
        }
    }

    public static ErrorInfoBuilder builder() {
        return new ErrorInfoBuilder();
    }

    public long getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class ErrorInfoBuilder {
        private long code;
        private String name;
        private String msg;

        ErrorInfoBuilder() {
        }

        public ErrorInfo.ErrorInfoBuilder code(long code) {
            this.code = code;
            return this;
        }

        public ErrorInfo.ErrorInfoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ErrorInfo.ErrorInfoBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ErrorInfo build() {
            return new ErrorInfo(this.code, this.name, this.msg);
        }

        @Override
        public String toString() {
            return "ErrorInfoBuilder(code=" + this.code + ", name=" + this.name + ", msg=" + this.msg + ")";
        }
    }
}