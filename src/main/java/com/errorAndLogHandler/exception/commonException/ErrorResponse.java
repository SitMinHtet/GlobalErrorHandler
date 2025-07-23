package com.errorAndLogHandler.exception.commonException;

import java.time.LocalDateTime;

public record ErrorResponse(
    LocalDateTime timestamp,
    String error,
    String message,
    String path,
    int status
    ) {
        public ErrorResponse(String error, String message, String path,int status) {
            this(LocalDateTime.now(), error, message, path,status);
        }
}

