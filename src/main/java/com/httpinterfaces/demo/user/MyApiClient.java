package com.httpinterfaces.demo.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api/resource")
public interface MyApiClient {

    @GetExchange
    ResponseEntity<String> getResource(@RequestParam String id);

    @PostExchange
    ResponseEntity<String> createResource(@RequestBody MyResource resource);
}
