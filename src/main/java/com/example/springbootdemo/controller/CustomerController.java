package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Customer;
import com.example.springbootdemo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
    @RequestMapping("/customerController")
    public class CustomerController {

    @RequestMapping("/test")
    public String test() {
        return "index";
    }

    @RequestMapping("/getCustomerInfoByModel")
    public String getCustomerInfoByModel(Model model) {
        /* Customer customer = new Customer(1,"张三",20);*/
        /*  model.addAttribute("customer",customer);*/
        return "customerList";
    }


       /* @RequestMapping("/getCustomerInfoByModelAndView")
        public ModelAndView getCustomerInfoByModelAndView(){
            Customer customer = new Customer(2,"李四",21);
            Map<String,Object> model = new HashMap<>();
            model.put("customer",customer);
            ModelAndView modelAndView = new ModelAndView("customerList",model);
            return modelAndView;
        }*/

    @RequestMapping("/getCustomerInfoByRedirect")
    public String getCustomerInfoByRedirect() {
        return "redirect:/customerController/getCustomerInfoByModel";
    }

    @RequestMapping("/getCustomerInfoByForward")
    public String getCustomerInfoByForward() {
        return "forward:/customerController/getCustomerInfoByModel";
    }

    @RequestMapping("/getCustomerInfoByUrl")
    @ResponseBody
    // 重定向到另一个控制器
    public String getCustomerInfoByUrl(@RequestParam("name") String userName) {
        return "用户名为：" + userName;
    }


    @RequestMapping("/getCustomerInfoByRestful/{name}")
    @ResponseBody
    //Restful风格
    public String getCustomerInfoByRestful(@PathVariable("name") String name) {
        return "用户名为：" + name;
    }


    @RequestMapping("/getCustomerInfoByDefault")
    @ResponseBody
    //默认数据类型
    public String getCustomerInfoByDefault(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        return "用户名为：" + userName + "密码为：" + passWord;
    }


    @RequestMapping("/getCustomerInfoByPojo")
    public String getCustomerInfoByPojo(Customer customer) {
        return "customerList";
    }

    @RequestMapping("/getAjaxJs")
    public String getAjaxJs() {
        return "ajax_js";
    }
    @RequestMapping("/getAjaxJq")
    public String getAjaxJq(){
        return "ajax_jq";
    }
@RequestMapping("/getAjaxResponse")
    public void getAjaxResponse(HttpServletRequest request, HttpServletResponse response)throws Exception  {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Thread.sleep(10000);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("用户名为：" + userName + "密码为：" + passWord);
    }

    @RequestMapping("/getThymeleafPage")
    public String getThymeleafPage(Model model){
         model.addAttribute("message","hello thymeleaf");
         User user = new User();
            user.setName("张三");
            user.setAge(20);
            model.addAttribute("user",user);
            User user2 = new User();
            user2.setName("李四");
            user2.setAge(21);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        model.addAttribute("userList",userList);
         return "test";}


    @RequestMapping("/getUserList")
    public String getUserList(Model model) {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        user1.setAge(20);
        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");
        user2.setAge(21);
        userList.add(user1);
        userList.add(user2);
        model.addAttribute("userList", userList);
        return "user_list";
    }
}
