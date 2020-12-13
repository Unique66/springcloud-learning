/*
 * Copyright (c) 2020.  User:SXH  File:MyRule.java
 * Date:2020/12/13 23:14:13
 */

package com.sxh.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SXH
 * @description MyRule 自定义负载均衡策略
 * @date 2020/12/13 23:14
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
