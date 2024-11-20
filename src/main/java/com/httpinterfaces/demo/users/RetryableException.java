package com.httpinterfaces.demo.users;

public class RetryableException extends RuntimeException {
    private final String customErrorCode;

    public RetryableException(String customErrorCode, String message) {
        super(message);
        this.customErrorCode = customErrorCode;
    }

    public String getCustomErrorCode() {
        return customErrorCode;
    }
}

