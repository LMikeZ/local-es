package com.example.lizan.error;


import com.example.lizan.util.Result;

/**
 * @author lizan
 * @version $Id: BizException.java, v 0.1 2022年06月08日 9:46 lizan Exp $$
 */

public class BizException extends AbstractBizException {
    private static final long serialVersionUID = -8667152650328536966L;
    protected String msg;
    private long code;
    private ErrorInfo error;

    public BizException(Result<?> result) {
        super(result);
        this.error = result.getError();
    }

    public BizException(ErrorInfo error) {
        this(error.getCode(), error.getName());
        this.error = error;
    }

    public BizException(ErrorInfo error, Throwable cause) {
        this(error.getCode(), error.getName(), cause);
        this.error = error;
    }

    public BizException(long code, String message) {
        super("{\"code\":" + code + ",\"message\":\"" + message + "\"}");
        this.code = code;
        this.msg = message;
    }

    public BizException(long code, String message, Throwable cause) {
        super("{\"code\":" + code + ",\"message\":\"" + message + "\"}", cause);
        this.code = code;
        this.msg = message;
    }

    public BizException() {
    }

    public String getMsg() {
        return this.msg;
    }

    public long getCode() {
        return this.code;
    }

    public ErrorInfo getError() {
        return this.error;
    }

    public void setError(ErrorInfo error) {
        this.error = error;
    }

}