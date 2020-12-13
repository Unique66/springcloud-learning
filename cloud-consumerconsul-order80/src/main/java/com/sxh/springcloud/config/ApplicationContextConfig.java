/*
 * Copyright (c) 2020.  User:SXH  File:ApplicationContextConfig.java
 * Date:2020/12/13 22:26:13
 */

package com.sxh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author SXH
 * @description ApplicationContextConfig
 * @date 2020/12/13 22:26
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
