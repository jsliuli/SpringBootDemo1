package com.example.springbootdemo;

import com.example.springbootdemo.controller.UserController;
import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootdemoApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    public void getUser(){
        String user = userController.getUser();
        System.out.println(user);
    }

}
