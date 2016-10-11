package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userdata")
public class UserDataController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User sendData(Authentication principal) {
        User user = userService.findByUserId((String) principal.getCredentials());
        return user;
    }
}
