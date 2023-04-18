package com.example.springbootdemo;

import com.example.springbootdemo.bean.User;
import com.example.springbootdemo.controller.UserController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Test
    public void getJacksonConverter() throws JsonProcessingException {
       //1.构造一个Jackson字符串
         String jacksonStr = "{\"id\":1,\"name\":\"zhangsan\",\"age\":18}";
         //2.创建Jackson核心对象
            ObjectMapper mapper = new ObjectMapper();
            //3.readValue方法完成数据间属性值的转换

                User user = mapper.readValue(jacksonStr, User.class);

                System.out.println(user);
    }

}
