/*
 * Copyright (c) 2020.  User:SXH  File:OrderFeignController.java
 * Date:2020/12/14 22:35:14
 */

package com.sxh.springcloud.controller;

import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import com.sxh.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description OrderFeignController
 * @date 2020/12/14 22:35
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
