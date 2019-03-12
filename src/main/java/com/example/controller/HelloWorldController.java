package com.example.controller;

import com.example.model.User;
import com.example.service.RedisService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    RedisService redisService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping(value="/hello1")
    public String setcache(){
        redisService.set("hh","bb",5000l);
        return "yes";
    }

    @RequestMapping(value="/hello2")
    public String getcache(){
        String result = (String)redisService.get("hh");

        return result ;
    }

    @RequestMapping(value="/addUser")
    public int addUser(User user){
       return userService.addUser(user);
    }
}
