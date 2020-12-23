/*
 * Copyright (c) 2020.  User:SXH  File:RateLimitController.java
 * Date:2020/12/23 22:42:23
 */

package com.sxh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sxh.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SXH
 * @description RateLimitController
 * @date 2020/12/23 22:42
 */
@RestController
public class RateLimitController {
    /**
     * 按照资源名称限流 配合SentinelResource 自定义降级响应
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK",
                new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,
                exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    /**
     * 按照URL 地址限流
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK",
                new Payment(2020L, "serial002"));
    }

    /**
     * 将降级信息归类到一个类中，统一管理
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义",
                new Payment(2020L, "serial003"));
    }
}
