/*
 * Copyright (c) 2020.  User:SXH  File:PaymentController.java
 * Date:2020/12/10 23:22:10
 */

package com.sxh.springcloud.controller;

import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import com.sxh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description PaymentController
 * @date 2020/12/10 23:22
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****insert result:" + result);
        if (result > 0) {  // 成功
            return new CommonResult(200, "insert db success.", result);
        } else {
            return new CommonResult(444, "insert db failed.", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****search result:" + payment);
        if (payment != null) {  // 说明有数据，能查询成功
            return new CommonResult(200, "search success.", payment);
        } else {
            return new CommonResult(444, "no record, search id:" + id, null);
        }
    }
}
