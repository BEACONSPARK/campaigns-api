package com.engageya.models;

/**
 * Created by DANIEL on 2/27/2017
 */
public class ResponsePayload<T> {
    private ErrorCode errorCode;
    private T data;

    public ResponsePayload(T data) {
        this.data = data;
        errorCode = ErrorCode.NONE;
    }

    public ResponsePayload(T data, ErrorCode errorCode) {
        this.data = data;
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
