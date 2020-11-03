package com.alibaba.nacos.example.spring.cloud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiehanchun on 2020/10/30
 */
@RestController
public class ProviderController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
}
