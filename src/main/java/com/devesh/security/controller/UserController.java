package com.devesh.security.controller;

import com.devesh.security.model.DeveshUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public void fun(){

        DeveshUser deveshUser = new DeveshUser();
        deveshUser.setUserId("1");
    }
}
