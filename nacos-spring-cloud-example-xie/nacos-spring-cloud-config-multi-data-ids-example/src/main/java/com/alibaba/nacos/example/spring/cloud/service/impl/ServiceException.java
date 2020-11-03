package com.alibaba.nacos.example.spring.cloud.service.impl;

import java.io.Serializable;

/**
 * Created by xiehanchun on 2020/11/3
 */
public class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ServiceException(String msg) {super(msg);}

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
