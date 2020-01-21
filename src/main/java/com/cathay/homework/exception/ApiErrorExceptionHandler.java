package com.cathay.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiErrorExceptionHandler {

    @ExceptionHandler({ApiErrorException.class})
    public final ResponseEntity<ApiErrorResponse> handleApiErrorException (ApiErrorException ex) {
        ApiErrorResponse response = new ApiErrorResponse(ex.getErrorMsg());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
