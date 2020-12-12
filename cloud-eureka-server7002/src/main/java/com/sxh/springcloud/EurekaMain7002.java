/*
 * Copyright (c) 2020.  User:SXH  File:EurekaMain7002.java
 * Date:2020/12/13 00:03:13
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author SXH
 * @description EurekaMain7002
 * @date 2020/12/13 0:03
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
