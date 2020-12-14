/*
 * Copyright (c) 2020.  User:SXH  File:FeignConfig.java
 * Date:2020/12/14 22:57:14
 */

package com.sxh.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SXH
 * @description FeignConfig 配置feign 的日志输出级别
 * @date 2020/12/14 22:57
 */
@Configuration
public class FeignConfig {
    /**
     * Logger.Level.NONE  -> 默认的，不显示任何日志
     * Logger.Level.BASIC -> 仅记录请求方法、URL、响应状态码及执行时间
     * Logger.Level.HEADERS -> 处理BASIC 中定义的信息之外，还有请求和响应的头信息
     * Logger.Level.FULL -> 处理HEADERS 中定义的信息之外，还有请求和响应的正文及元数据
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
