/*
 * Copyright (c) 2020.  User:SXH  File:PaymentHystrixMain8001.java
 * Date:2020/12/15 23:21:15
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SXH
 * @description PaymentHystrixMain8001
 * @date 2020/12/15 23:21
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
