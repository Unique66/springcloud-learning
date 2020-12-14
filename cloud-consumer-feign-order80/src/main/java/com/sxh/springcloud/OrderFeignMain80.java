/*
 * Copyright (c) 2020.  User:SXH  File:OrderFeignMain80.java
 * Date:2020/12/14 22:29:14
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SXH
 * @description OrderFeignMain80
 * @date 2020/12/14 22:29
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
