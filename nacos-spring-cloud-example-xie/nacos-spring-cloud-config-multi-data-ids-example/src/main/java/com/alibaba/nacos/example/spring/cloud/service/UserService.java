package com.alibaba.nacos.example.spring.cloud.service;

import com.alibaba.nacos.example.spring.cloud.service.impl.ServiceException;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by xiehanchun on 2020/10/30
 */
//@Service (使用FeignClient时需要在调用方加feign-okhttp version 10.9 )
@FeignClient(name = "user-service",path = "/user/service",fallbackFactory = UserService.DefaultFallbackFactory.class)
public interface UserService {

//    User findById(Long id);

    @GetMapping("/getStr/{str}")
    String getStr(@PathVariable(value = "str") String str);

    @Component
    class DefaultFallbackFactory  implements FallbackFactory<UserService> {

        @Override
        public UserService create(Throwable throwable) {
            throwable.printStackTrace();
            throw new ServiceException(throwable.getMessage());
        }

    }

}