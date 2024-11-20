package com.httpinterfaces.demo.user;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

import java.util.function.Supplier;

@Component
public class RestClientHelper {

    private final RestClientErrorHandler errorHandler;

    public RestClientHelper(RestClientErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public <T> T executeWithRetry(Supplier<T> apiCall) {
        try {
            return apiCall.get();
        } catch (RestClientResponseException ex) {
            errorHandler.handleError(ex); // Centralized error handling
            throw ex;
        }
    }
}
