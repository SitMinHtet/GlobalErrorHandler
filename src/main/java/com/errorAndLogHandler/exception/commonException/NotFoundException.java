package com.errorAndLogHandler.exception.commonException;

public class NotFoundException extends ApiException {
    public NotFoundException(String message) {
        super(message);
    }
}