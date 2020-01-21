package com.cathay.homework.exception;

public class ApiErrorResponse {

    private String errorMsg;

    public ApiErrorResponse (String message) {
        this.errorMsg = message;
    }

    public String getMessage() {
        return errorMsg;
    }

    public void setMessage(String message) {
        this.errorMsg = message;
    }
}
