package com.devesh.security.controller;

import com.devesh.security.model.DeveshUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getUser")
    public String getUser(){
        return "User Fetch SuccessFully";
    }
}
