package com.httpinterfaces.demo.user;

public class RetryableException extends RuntimeException {
    public RetryableException(String message) {
        super(message);
    }
}

