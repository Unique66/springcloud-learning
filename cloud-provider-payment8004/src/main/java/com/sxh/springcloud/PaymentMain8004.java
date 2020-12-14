/*
 * Copyright (c) 2020.  User:SXH  File:PaymentMain8004.java
 * Date:2020/12/14 21:31:14
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SXH
 * @description PaymentMain8004 测试zookeeper
 * @date 2020/12/14 21:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
