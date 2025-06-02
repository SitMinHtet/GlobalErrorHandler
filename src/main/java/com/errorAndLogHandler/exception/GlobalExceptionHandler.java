package com.errorAndLogHandler.exception;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.errorAndLogHandler.exception.commonException.*;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        logger.warn("Not Found: {}", ex.getMessage());
        return ResponseEntity.status(404).body(new ErrorResponse("Not Found", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, HttpServletRequest request) {
        logger.warn("Bad Request: {}", ex.getMessage());
        return ResponseEntity.badRequest().body(new ErrorResponse("Bad Request", ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex, HttpServletRequest request) {
        logger.error("Internal Server Error: {}", ex.getMessage(), ex);
        return ResponseEntity.status(500).body(new ErrorResponse("Internal Server Error", ex.getMessage(), request.getRequestURI()));
    }
}
