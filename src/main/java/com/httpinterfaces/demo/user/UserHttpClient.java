package com.httpinterfaces.demo.user;


import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserHttpClient {

    @GetExchange("/users")
    List<User> findAll();
}
