/*
 * Copyright (c) 2020.  User:SXH  File:PaymentFeignService.java
 * Date:2020/12/14 22:32:14
 */

package com.sxh.springcloud.service;

import com.sxh.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author SXH
 * @description PaymentFeignService 接口配合FeignClient 注解完成远程调用
 * @date 2020/12/14 22:32
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * openfeign 通过接口和注解配置方式，实现远程调用和负载均衡
     * 如下，接口为服务提供者的controller 层接口信息
     */
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
