/*
 * Copyright (c) 2020.  User:SXH  File:NacosConfigClientMain3377.java
 * Date:2020/12/21 21:18:21
 */

package com.sxh.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author SXH
 * @description NacosConfigClientMain3377
 * @date 2020/12/21 21:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
    }
}
