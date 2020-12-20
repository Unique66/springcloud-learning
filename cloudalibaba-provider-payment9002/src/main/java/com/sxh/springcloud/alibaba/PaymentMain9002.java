/*
 * Copyright (c) 2020.  User:SXH  File:PaymentMain9002.java
 * Date:2020/12/20 22:26:20
 */

package com.sxh.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SXH
 * @description PaymentMain9001 cloudalibaba
 * @date 2020/12/20 22:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9002.class, args);
    }
}
