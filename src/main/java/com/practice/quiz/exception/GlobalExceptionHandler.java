package com.practice.quiz.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleQuestionNotFoundException(QuestionNotFoundException ex, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(),request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
