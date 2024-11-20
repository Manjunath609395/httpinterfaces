package com.httpinterfaces.demo.finals;

public class CustomApiException extends RuntimeException {
    private final String errorCode;
    private final int httpStatus;
    private final String externalResponse;

    public CustomApiException(String errorCode, int httpStatus, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.externalResponse = null;
    }

    public CustomApiException(String errorCode, int httpStatus, String message, String externalResponse) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.externalResponse = externalResponse;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getExternalResponse() {
        return externalResponse;
    }
}
