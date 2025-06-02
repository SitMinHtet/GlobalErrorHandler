package com.errorAndLogHandler.exception.commonException;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(message);
    }
}
