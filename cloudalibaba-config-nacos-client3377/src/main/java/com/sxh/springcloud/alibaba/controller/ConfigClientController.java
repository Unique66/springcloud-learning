/*
 * Copyright (c) 2020.  User:SXH  File:ConfigClientController.java
 * Date:2020/12/21 21:19:21
 */

package com.sxh.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SXH
 * @description ConfigClientController
 * @date 2020/12/21 21:19
 */
@RestController
@RefreshScope // 实现配置自动更新
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
