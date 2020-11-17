package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.nacos.example.spring.cloud.entity.User;
import com.alibaba.nacos.example.spring.cloud.service.UserService;
import com.alibaba.nacos.example.spring.cloud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by xiehanchun on 2020/11/16
 */
@Component
public class EvenHandler {
//    @Qualifier("user-service")
//    @Autowired
//    private UserServiceImpl userService;
    @Autowired
    private UserService userService;

    @Async
    @EventListener(classes = User.class)
    public void getUser(){
        String str = userService.getStr("xiehanchun");
        System.out.println(str);
    }
}
