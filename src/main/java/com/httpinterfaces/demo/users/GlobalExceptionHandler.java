package com.httpinterfaces.demo.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<Map<String, String>> handleCustomApiException(CustomApiException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("errorCode", ex.getCustomErrorCode());
        response.put("errorMessage", ex.getMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }
}
