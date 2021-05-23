package com.example.roomtest.core;

public class BaseResponse<T> {

    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 额外信息
     */
    private String message;
    /**
     * 真正返回数据
     */
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccessful() {
        return errorCode == 0;
    }
}
