package com.httpinterfaces.demo.user;

import org.springframework.http.HttpStatus;

public class CustomApiException extends RuntimeException {
    private final HttpStatus statusCode;

    public CustomApiException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
