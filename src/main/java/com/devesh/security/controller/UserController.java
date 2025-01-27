package com.devesh.security.controller;

import com.devesh.security.model.DeveshUser;
import com.devesh.security.service.DeveshUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private DeveshUserService deveshUserService;


    @GetMapping("/getUser")
    public String getUser(){
        return "User Fetch SuccessFully";
    }

    @GetMapping("/registerUser")
    public DeveshUser registerUser(@RequestBody DeveshUser deveshUser){
        return deveshUserService.registerUser(deveshUser);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody DeveshUser deveshUser){
        return deveshUserService.verifyUser(deveshUser);
    }
}
