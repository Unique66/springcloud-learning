/*
 * Copyright (c) 2020.  User:SXH  File:OrderHystrixMain80.java
 * Date:2020/12/15 23:34:15
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SXH
 * @description OrderHystrixMain80
 * @date 2020/12/15 23:34
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
