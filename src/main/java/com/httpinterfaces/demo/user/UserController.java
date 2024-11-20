package com.httpinterfaces.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRestClient userRestClient;

    private final UserHttpClient userHttpClient;


    public UserController(UserRestClient userRestClient, UserHttpClient userHttpClient) {
        this.userRestClient = userRestClient;
        this.userHttpClient = userHttpClient;
    }

    @GetMapping
    public List<User> findAll() {
        return userHttpClient.findAll();
    }
}
