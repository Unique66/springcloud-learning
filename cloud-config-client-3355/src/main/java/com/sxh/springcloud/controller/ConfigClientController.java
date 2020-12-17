/*
 * Copyright (c) 2020.  User:SXH  File:ConfigClientController.java
 * Date:2020/12/17 23:00:17
 */

package com.sxh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SXH
 * @description ConfigClientController
 * @date 2020/12/17 23:00
 */
@RestController
@RefreshScope // 客户端添加配置监控，保证实时刷新
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
