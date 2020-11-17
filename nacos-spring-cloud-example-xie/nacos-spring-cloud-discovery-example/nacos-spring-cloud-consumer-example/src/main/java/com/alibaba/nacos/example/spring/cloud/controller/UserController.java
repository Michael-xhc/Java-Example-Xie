package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.nacos.example.spring.cloud.entity.User;
import com.alibaba.nacos.example.spring.cloud.handler.ApplicationContexts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiehanchun on 2020/11/16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
      * @Author xiehanchun
      * @Description //TODO
      * @Date 2020/11/16
      * @Param
      * @return
      */
    @GetMapping("/getUser")
    public void getUser(){
        User user = new User();
        user.setUserId(9527);
        user.setName("xiehanchun");
        try {
            ApplicationContexts.getApplicationContext().publishEvent(user);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("userID:"+user.getUserId()+"  userName:"+user.getName());
    }

}
