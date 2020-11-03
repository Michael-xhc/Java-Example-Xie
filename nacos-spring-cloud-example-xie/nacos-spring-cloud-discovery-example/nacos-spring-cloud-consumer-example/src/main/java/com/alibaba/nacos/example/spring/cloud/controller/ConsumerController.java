package com.alibaba.nacos.example.spring.cloud.controller;

import com.alibaba.nacos.example.spring.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiehanchun on 2020/10/30
 */
@RestController
@RequestMapping("/api")
public class ConsumerController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        System.out.println("1111");
        return restTemplate.getForObject("http:192.168.165.154:8083/service-provider/echo/" + str, String.class);
//        return null;
    }

    @GetMapping("/getStr/{str}")
    public String getStr(@PathVariable(value = "str") String str){
        System.out.println("----------"+str);
        System.out.println("1111111");
        return userService.getStr(str);
//        return null;
    }



}
