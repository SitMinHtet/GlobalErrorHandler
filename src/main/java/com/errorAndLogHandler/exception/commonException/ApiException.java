package com.errorAndLogHandler.exception.commonException;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}