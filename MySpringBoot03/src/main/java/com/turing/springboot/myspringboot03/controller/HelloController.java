package com.turing.springboot.myspringboot03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String,String> getUser(){
        Map<String,String> user = new HashMap<>();
        user.put("username","admin");
        user.put("password","123");
        return user;
    }
}
