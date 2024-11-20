package com.httpinterfaces.demo.finals;

@Component
public class ApiErrorHandler {

    public void handleError(Exception ex) {
        if (ex instanceof HttpStatusCodeException) {
            HttpStatusCodeException httpEx = (HttpStatusCodeException) ex;
            int statusCode = httpEx.getRawStatusCode();
            String responseBody = httpEx.getResponseBodyAsString();

            // Custom error mapping
            String customErrorCode = mapToCustomErrorCode(statusCode);
            String customErrorMessage = "Error occurred with external service";

            throw new CustomApiException(customErrorCode, statusCode, customErrorMessage, responseBody);
        } else if (ex instanceof ReadTimeoutException) {
            throw new CustomApiException("ERR_READ_TIMEOUT", 408, "Read timeout occurred");
        }

        throw new RuntimeException("Unexpected error", ex);
    }

    private String mapToCustomErrorCode(int statusCode) {
        return switch (statusCode) {
            case 400 -> "ERR_BAD_REQUEST";
            case 401 -> "ERR_UNAUTHORIZED";
            case 404 -> "ERR_NOT_FOUND";
            case 503 -> "ERR_SERVICE_UNAVAILABLE";
            default -> "ERR_UNKNOWN";
        };
    }
}
