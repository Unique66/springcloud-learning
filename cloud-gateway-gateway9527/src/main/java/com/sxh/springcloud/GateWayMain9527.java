/*
 * Copyright (c) 2020.  User:SXH  File:GateWayMain9527.java
 * Date:2020/12/16 23:09:16
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SXH
 * @description GateWayMain9527
 * @date 2020/12/16 23:09
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
