/*
 * Copyright (c) 2020.  User:SXH  File:PaymentFallbackService.java
 * Date:2020/12/16 00:24:16
 */

package com.sxh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author SXH
 * @description PaymentFallbackService  统一一个类来处理服务降级，降低代码耦合度
 * @date 2020/12/16 0:24
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
