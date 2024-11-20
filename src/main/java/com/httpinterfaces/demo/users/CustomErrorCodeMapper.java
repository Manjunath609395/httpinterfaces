package com.httpinterfaces.demo.users;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomErrorCodeMapper {

    private static final Map<HttpStatus, String> ERROR_CODE_MAP = Map.of(
        HttpStatus.BAD_REQUEST, "ERR_400",
        HttpStatus.UNAUTHORIZED, "ERR_401",
        HttpStatus.FORBIDDEN, "ERR_403",
        HttpStatus.NOT_FOUND, "ERR_404",
        HttpStatus.INTERNAL_SERVER_ERROR, "ERR_500",
        HttpStatus.SERVICE_UNAVAILABLE, "ERR_503"
    );

    public String mapToCustomCode(HttpStatus statusCode) {
        return ERROR_CODE_MAP.getOrDefault(statusCode, "ERR_UNKNOWN");
    }
}
