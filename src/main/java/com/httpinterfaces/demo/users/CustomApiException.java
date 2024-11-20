package com.httpinterfaces.demo.users;

public class CustomApiException extends RuntimeException {
    private final HttpStatus statusCode;
    private final String customErrorCode;

    public CustomApiException(String customErrorCode, HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.customErrorCode = customErrorCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getCustomErrorCode() {
        return customErrorCode;
    }
}
