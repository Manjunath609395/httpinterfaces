package com.httpinterfaces.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

@Component
public class RestClientErrorHandler {

    public void handleError(RestClientResponseException ex) {
        HttpStatus statusCode = HttpStatus.valueOf(ex.getStatusCode().value());
        String errorMessage = ex.getResponseBodyAsString();

        if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
            // Custom retryable exception
            throw new RetryableException("Service unavailable: " + errorMessage);
        } else {
            // Handle other status codes
            throw new CustomApiException(statusCode, errorMessage);
        }
    }
}
