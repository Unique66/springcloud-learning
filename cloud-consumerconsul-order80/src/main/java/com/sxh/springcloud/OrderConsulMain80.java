/*
 * Copyright (c) 2020.  User:SXH  File:OrderConsulMain80.java
 * Date:2020/12/13 22:25:13
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SXH
 * @description OrderConsulMain80
 * @date 2020/12/13 22:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
