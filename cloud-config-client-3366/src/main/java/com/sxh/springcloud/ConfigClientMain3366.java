/*
 * Copyright (c) 2020.  User:SXH  File:ConfigClientMain3366.java
 * Date:2020/12/18 22:20:18
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SXH
 * @description ConfigClientMain3366
 * @date 2020/12/18 22:20
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run( ConfigClientMain3366.class,args);
    }
}
