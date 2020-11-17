package com.alibaba.nacos.example.spring.cloud.service.impl;

import com.alibaba.nacos.example.spring.cloud.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiehanchun on 2020/10/30
 */
@RestController
@RequestMapping("/user/service")
public class UserServiceImpl /*implements UserService*/{

    @PostMapping("/getStr")
    public String getStr(@RequestParam("str") String str){
        System.out.println(str);
        return "hello " + str;
    }

}