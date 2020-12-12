/*
 * Copyright (c) 2020.  User:SXH  File:PaymentMain8001.java
 * Date:2020/12/10 22:06:10
 */

package com.sxh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SXH
 * @description PaymentMain8002
 * @date 2020/12/10 22:06
 */
@SpringBootApplication
@MapperScan("com.sxh.springcloud.dao")
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
