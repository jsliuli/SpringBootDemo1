package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
    @RequestMapping("/customerController")
    public class CustomerController {

        @RequestMapping("/test")
        public String test(){
            return "index";
        }

        @RequestMapping("/getCustomerInfoByModel")
        public String getCustomerInfoByModel(Model model){
            Customer customer = new Customer(1,"张三",20);
            model.addAttribute("customer",customer);
            return "customerList";
        }


        @RequestMapping("/getCustomerInfoByModelAndView")
        public ModelAndView getCustomerInfoByModelAndView(){
            Customer customer = new Customer(2,"李四",21);
            Map<String,Object> model = new HashMap<>();
            model.put("customer",customer);
            ModelAndView modelAndView = new ModelAndView("customerList",model);
            return modelAndView;
        }

        @RequestMapping("/getCustomerInfoByRedirect")
        public String getCustomerInfoByRedirect(){
            return "redirect:/customerController/getCustomerInfoByModel";
        }

        @RequestMapping("/getCustomerInfoByForward")
        public String getCustomerInfoByForward(){
            return "forward:/customerController/getCustomerInfoByModel";
        }
}
