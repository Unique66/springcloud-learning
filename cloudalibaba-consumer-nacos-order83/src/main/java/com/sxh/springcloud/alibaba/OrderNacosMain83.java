/*
 * Copyright (c) 2020.  User:SXH  File:OrderNacosMain83.java
 * Date:2020/12/20 22:39:20
 */

package com.sxh.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SXH
 * @description OrderNacosMain83
 * @date 2020/12/20 22:39
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OrderNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain83.class, args);
    }
}
