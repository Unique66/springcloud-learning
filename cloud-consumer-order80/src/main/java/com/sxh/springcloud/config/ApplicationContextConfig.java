/*
 * Copyright (c) 2020.  User:SXH  File:ApplicationContextConfig.java
 * Date:2020/12/12 17:16:12
 */

package com.sxh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author SXH
 * @description 配置
 * @date 2020/12/12 17:16
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
