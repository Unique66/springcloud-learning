/*
 * Copyright (c) 2020.  User:SXH  File:ApplicationContextConfig.java
 * Date:2020/12/14 21:46:14
 */

package com.sxh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author SXH
 * @description ApplicationContextConfig
 * @date 2020/12/14 21:46
 */
@Configuration
public class ApplicationContextConfig {
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
