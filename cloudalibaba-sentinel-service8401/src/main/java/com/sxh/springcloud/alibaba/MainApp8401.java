/*
 * Copyright (c) 2020.  User:SXH  File:MainApp8401.java
 * Date:2020/12/23 22:04:23
 */

package com.sxh.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SXH
 * @description MainApp8401
 * @date 2020/12/23 22:04
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401
{
    public static void main(String[] args) {
        SpringApplication.run(MainApp8401.class, args);
    }
}

