package com.httpinterfaces.demo.users;

import com.httpinterfaces.demo.user.CustomApiException;
import com.httpinterfaces.demo.user.RetryableException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

@Component
public class RestClientErrorHandler {

    private final CustomErrorCodeMapper errorCodeMapper;

    public RestClientErrorHandler(CustomErrorCodeMapper errorCodeMapper) {
        this.errorCodeMapper = errorCodeMapper;
    }

    public void handleError(RestClientResponseException ex) {
        HttpStatus statusCode = HttpStatus.valueOf(ex.getRawStatusCode());
        String errorMessage = ex.getResponseBodyAsString();
        String customErrorCode = errorCodeMapper.mapToCustomCode(statusCode);

        if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
            throw new RetryableException(customErrorCode, "Service unavailable: " + errorMessage);
        } else {
            throw new CustomApiException(customErrorCode, statusCode, errorMessage);
        }
    }
}
