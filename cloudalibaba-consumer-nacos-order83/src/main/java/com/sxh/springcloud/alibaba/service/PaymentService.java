/*
 * Copyright (c) 2020.  User:SXH  File:PaymentService.java
 * Date:2020/12/23 23:54:23
 */

package com.sxh.springcloud.alibaba.service;

import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author SXH
 * @description PaymentService  openfeign service 接口
 * @date 2020/12/23 23:54
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
