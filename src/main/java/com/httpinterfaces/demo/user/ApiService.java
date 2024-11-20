package com.httpinterfaces.demo.user;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

@Service
public class ApiService {

    private final MyApiClient myApiClient;
    private final RestClientErrorHandler errorHandler;

    public ApiService(MyApiClient myApiClient, RestClientErrorHandler errorHandler) {
        this.myApiClient = myApiClient;
        this.errorHandler = errorHandler;
    }

    @Retryable(
        value = RetryableException.class,
        maxAttempts = 3,
        backoff = @Backoff(delay = 2000)
    )
    public String getResource(String id) {
        try {
            return myApiClient.getResource(id).getBody();
        } catch (RestClientResponseException ex) {
            errorHandler.handleError(ex);
            throw ex; // This will trigger Spring Retry for RetryableException
        }
    }

    @Recover
    public String recoverFromRetryableException(RetryableException ex) {
        return "Service is currently unavailable. Please try again later.";
    }
}
