package com.httpinterfaces.demo.users;

import com.httpinterfaces.demo.user.MyApiClient;
import com.httpinterfaces.demo.user.RestClientHelper;
import com.httpinterfaces.demo.user.RetryableException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final MyApiClient myApiClient;
    private final RestClientHelper restClientHelper;

    public ApiService(MyApiClient myApiClient, RestClientHelper restClientHelper) {
        this.myApiClient = myApiClient;
        this.restClientHelper = restClientHelper;
    }

    @Retryable(
        value = RetryableException.class,
        maxAttempts = 3,
        backoff = @Backoff(delay = 2000)
    )
    public String getResource(String id) {
        return restClientHelper.executeWithRetry(() -> myApiClient.getResource(id).getBody());
    }

    @Recover
    public String recoverFromRetryableException(RetryableException ex) {
        return "Service is currently unavailable. Please try again later.";
    }
}
