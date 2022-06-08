package com.example.lizan.util;

/**
 * @author lizan
 * @version $Id: Result.java, v 0.1 2022年06月08日 9:48 lizan Exp $$
 */

import com.example.lizan.error.ErrorInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 5947203836182608272L;
    private boolean success;
    private T value;
    private ErrorInfo error;
    private Throwable throwable;
    private String remark;
    @JsonIgnore
    private List<ErrorInfo> errorList;
    private boolean printValue = true;

    public Result() {
    }

    public static <T> Result<T> success(Result<?> result, T value) {
        return new Result(result.isSuccess(), value, result.getError(), result.getThrowable(), result.getRemark());
    }

    public static <T> Result<T> success() {
        return new Result(true, (Object) null, (ErrorInfo) null, (Throwable) null);
    }

    public static <T> Result<T> success(T value) {
        return new Result(true, value, (ErrorInfo) null, (Throwable) null);
    }

    public static <T> Result<T> success(T value, boolean printValue) {
        return new Result(true, value, (ErrorInfo) null, (Throwable) null, (String) null, (List) null, printValue);
    }

    public static <T> Result<T> success(T value, String remark) {
        return new Result(true, value, (ErrorInfo) null, (Throwable) null, remark);
    }

    public static <T> Result<T> success(ErrorInfo error) {
        return new Result(true, (Object) null, error, (Throwable) null);
    }

    public static <T> Result<T> success(T value, String remark, ErrorInfo error) {
        return new Result(true, value, error, (Throwable) null, remark);
    }

    public static <T> Result<T> success(T value, ErrorInfo error) {
        return new Result(true, value, error, (Throwable) null);
    }

    public static <T> Result<T> success(T value, List<ErrorInfo> errorList) {
        return new Result(true, value, (ErrorInfo) null, (Throwable) null, errorList);
    }

    public static <T> Result<T> success(T value, ErrorInfo error, List<ErrorInfo> errorList) {
        return new Result(true, value, error, (Throwable) null, errorList);
    }

    public static <T> Result<T> error(ErrorInfo error) {
        return new Result(false, (Object) null, error, (Throwable) null);
    }

    public static <T> Result<T> error(ErrorInfo error, Throwable throwable) {
        return new Result(false, (Object) null, error, throwable);
    }

    public static <T> Result<T> error(ErrorInfo error, String remark) {
        return new Result(false, (Object) null, error, (Throwable) null, remark);
    }

    public static <T> Result<T> error(Result<?> result) {
        return new Result(false, (Object) null, result.getError(), result.getThrowable(), result.getRemark());
    }

    public static <T> Result<T> error(Result<?> result, ErrorInfo error) {
        return new Result(false, (Object) null, error, result.getThrowable(), result.getRemark());
    }

    public Result(boolean success, T value, ErrorInfo error, Throwable throwable, String remark, List<ErrorInfo> errorList, boolean printValue) {
        this.success = success;
        this.value = value;
        this.error = error;
        this.throwable = throwable;
        this.remark = remark;
        this.errorList = errorList;
        this.printValue = printValue;
    }

    public Result(boolean success, T value, ErrorInfo error, Throwable throwable, String remark, List<ErrorInfo> errorList) {
        this.success = success;
        this.value = value;
        this.error = error;
        this.throwable = throwable;
        this.remark = remark;
        this.errorList = errorList;
    }

    public Result(boolean success, T value, ErrorInfo error, Throwable throwable, List<ErrorInfo> errorList) {
        this.success = success;
        this.value = value;
        this.error = error;
        this.throwable = throwable;
        this.errorList = errorList;
    }

    public Result(boolean success, T value, ErrorInfo error, Throwable throwable, String remark) {
        this.success = success;
        this.value = value;
        this.error = error;
        this.throwable = throwable;
        this.remark = remark;
    }

    public Result(boolean success, T value, ErrorInfo error, Throwable throwable) {
        this.success = success;
        this.value = value;
        this.error = error;
        this.throwable = throwable;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ErrorInfo getError() {
        return this.error;
    }

    public void setError(ErrorInfo error) {
        this.error = error;
    }

    @JsonIgnore
    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getThrowableStackTrace() {
        if (null != this.throwable) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            this.throwable.printStackTrace(new PrintStream(out));
            return out.toString();
        } else {
            return "无异常被捕获";
        }
    }

    public boolean isEmpty() {
        return null == this.value;
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    public boolean hasValue() {
        return this.isSuccess() && this.isNotEmpty();
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @JsonIgnore
    public List<ErrorInfo> getErrorList() {
        return this.errorList;
    }

    public void setErrorList(List<ErrorInfo> errorList) {
        this.errorList = errorList;
    }

    public String toString() {
        return this.success && !this.printValue ? "" : ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}