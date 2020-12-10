/*
 * Copyright (c) 2020.  User:SXH  File:PaymentMain8001.java
 * Date:2020/12/10 22:06:10
 */

package com.sxh.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author SXH
 * @description PaymentMain8001
 * @date 2020/12/10 22:06
 */
@SpringBootApplication
@MapperScan("com.sxh.springcloud.dao")
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
