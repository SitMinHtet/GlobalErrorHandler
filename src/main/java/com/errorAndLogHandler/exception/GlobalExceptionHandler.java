package com.errorAndLogHandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.errorAndLogHandler.exception.commonException.*;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletRequest request) {
        int status = HttpStatus.NOT_FOUND.value();
        return ResponseEntity.status(200).body(new ErrorResponse("Not Found", ex.getMessage(), request.getRequestURI(),status));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException ex, HttpServletRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        return ResponseEntity.status(200).body(new ErrorResponse("Bad Request", ex.getMessage(), request.getRequestURI(),status));
    }
    
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleMethodMisMatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        int status = HttpStatus.BAD_REQUEST.value();
        return ResponseEntity.status(200).body(new ErrorResponse("Bad Request", ex.getMessage(), request.getRequestURI(),status));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex, HttpServletRequest request) {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return ResponseEntity.status(200).body(new ErrorResponse("Internal Server Error", ex.getMessage(), request.getRequestURI(),status));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistException ex, HttpServletRequest request) {
        int status = HttpStatus.CONFLICT.value();
        return ResponseEntity.status(200).body(
            new ErrorResponse("Conflict", ex.getMessage(), request.getRequestURI(),status)
        );
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex, HttpServletRequest request) {
        int status = HttpStatus.UNAUTHORIZED.value();
        return ResponseEntity.status(200).body(
            new ErrorResponse("Unauthorized", ex.getMessage(), request.getRequestURI(),status)
        );
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ErrorResponse> handleInvalidJwtToken(JwtException ex, HttpServletRequest request) {
        int status = HttpStatus.FORBIDDEN.value();
        return ResponseEntity.status(200).body(
            new ErrorResponse("Forbidden", "Invalid or expired token", request.getRequestURI(), status)
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) {
        int status = HttpStatus.FORBIDDEN.value();
        return ResponseEntity.status(200).body(
            new ErrorResponse("Forbidden", "Access is denied", request.getRequestURI(), status)
        );
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationError(AuthenticationException ex, HttpServletRequest request) {
        int status = HttpStatus.UNAUTHORIZED.value();
        return ResponseEntity.status(200).body(
            new ErrorResponse("Unauthorized", ex.getMessage(), request.getRequestURI(), status)
        );
    }
}
