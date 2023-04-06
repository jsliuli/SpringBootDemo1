package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public String getUser(){
        User user = userService.getUser();
        return user.toString();
    }

}
