/*
 * Copyright (c) 2020.  User:SXH  File:ConfigCenterMain3344.java
 * Date:2020/12/17 22:14:17
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author SXH
 * @description ConfigCenterMain3344
 * @date 2020/12/17 22:14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
