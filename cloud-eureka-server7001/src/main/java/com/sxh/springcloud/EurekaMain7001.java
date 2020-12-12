/*
 * Copyright (c) 2020.  User:SXH  File:EurekaMain7001.java
 * Date:2020/12/12 18:16:12
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author SXH
 * @description EurekaMain7001 服务注册中心
 * @date 2020/12/12 18:16
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
