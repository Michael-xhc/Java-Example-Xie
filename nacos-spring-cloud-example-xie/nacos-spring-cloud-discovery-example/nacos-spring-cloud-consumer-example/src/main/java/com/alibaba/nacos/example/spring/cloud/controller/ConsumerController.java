package com.alibaba.nacos.example.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

//    @Autowired
//    private UserService userService;

//    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        System.out.println("1111");
        return restTemplate.getForObject("http:192.168.165.154:8083/service-provider/echo/" + str, String.class);
    }

    @GetMapping("/getStr/{str}")
    public String getStr(@PathVariable String Str){
        return null;
    }
}
