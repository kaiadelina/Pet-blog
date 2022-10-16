package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration", consumes = {"application/json"})
    public String addUser(@RequestBody User user) {
        if (!userService.saveUser(user)) {
            throw new IllegalArgumentException();
        }
        return "OK";
    }
}
