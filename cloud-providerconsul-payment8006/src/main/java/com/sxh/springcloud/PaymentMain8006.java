/*
 * Copyright (c) 2020.  User:SXH  File:PaymentMain8006.java
 * Date:2020/12/13 22:16:13
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SXH
 * @description PaymentMain8006
 * @date 2020/12/13 22:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
