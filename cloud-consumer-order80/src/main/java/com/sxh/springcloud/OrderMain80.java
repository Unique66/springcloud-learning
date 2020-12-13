/*
 * Copyright (c) 2020.  User:SXH  File:OrderMain80.java
 * Date:2020/12/12 17:12:12
 */

package com.sxh.springcloud;

import com.sxh.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author SXH
 * @description OrderMain80 启动类
 * @date 2020/12/12 17:12
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
