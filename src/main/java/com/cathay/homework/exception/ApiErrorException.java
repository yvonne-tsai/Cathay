package com.cathay.homework.exception;

public class ApiErrorException extends RuntimeException {

    private String errorMsg;

    public ApiErrorException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
