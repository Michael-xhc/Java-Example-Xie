package com.alibaba.nacos.example.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiehanchun on 2020/10/30
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    /**
      * @Author xiehanchun
      * @Description //http://localhost:8080/config/get
      * @Date 2020/10/30
      * @Param
      * @return
      */
    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}