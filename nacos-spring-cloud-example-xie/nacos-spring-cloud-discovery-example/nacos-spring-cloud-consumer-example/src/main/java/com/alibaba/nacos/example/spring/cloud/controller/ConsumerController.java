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

    /**
      * @Author xiehanchun
      * @Description //TODO
      * @Date 2020/11/13
      * @Param
      * @return
      * 并发：通过加版本锁解决
      * 分布式锁 seata
      * 事件 监听 Source：事件源，即触发事件的对象； EventObject：事件对象，即带有 EventSource 信息的事件对象，是对EventSource的包装；Eventlistener：事件监听器，对该事件的处理。；
      * 网关 gateway zuul
      *
      */
    @GetMapping("/getStr/{str}")
    public String getStr(@PathVariable(value = "str") String str){
        System.out.println("----------"+str);
        System.out.println("1111111");
        return userService.getStr(str);
//        return null;
    }



}
