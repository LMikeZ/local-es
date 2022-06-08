package com.example.lizan.error;

/**
 * @author lizan
 * @version $Id: AbstractBizException.java, v 0.1 2022年06月08日 9:50 lizan Exp $$
 */

import com.example.lizan.util.Result;
import org.springframework.util.ObjectUtils;

public abstract class AbstractBizException extends RuntimeException {
    private static final long serialVersionUID = 5937094037961715618L;
    protected ErrorInfo error;

    public AbstractBizException() {
    }

    public AbstractBizException(Result<?> result) {
        this(result.getError().getCode(), result.getError().getName(), result.getThrowable());
        this.error = result.getError();
    }

    public AbstractBizException(ErrorInfo error) {
        this.error = error;
    }

    public AbstractBizException(ErrorInfo error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public AbstractBizException(String message) {
        super(message);
        this.error = new ErrorInfo((long) ErrorInfo.DEFAULT_ERROR_CODE, message);
    }

    public AbstractBizException(String message, Throwable cause) {
        super(message, cause);
        this.error = new ErrorInfo((long) ErrorInfo.DEFAULT_ERROR_CODE, message);
    }

    public AbstractBizException(long code, String message, Throwable cause) {
        super("{\"code\":" + code + ",\"message\":\"" + message + "\"}", cause);
        this.error = new ErrorInfo(code, message);
    }

    public AbstractBizException(Throwable cause) {
        super(cause);
    }

    public AbstractBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = new ErrorInfo((long) ErrorInfo.DEFAULT_ERROR_CODE, message);
    }

    public String getMessage() {
        return ObjectUtils.nullSafeEquals((Object) null, this.error) ? super.getMessage() : this.error.toString();
    }

    public ErrorInfo getError() {
        return this.error;
    }
}