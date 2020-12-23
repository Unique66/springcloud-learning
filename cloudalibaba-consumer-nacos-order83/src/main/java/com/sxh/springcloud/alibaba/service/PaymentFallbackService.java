/*
 * Copyright (c) 2020.  User:SXH  File:PaymentFallbackService.java
 * Date:2020/12/23 23:53:23
 */

package com.sxh.springcloud.alibaba.service;

import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author SXH
 * @description PaymentFallbackService
 * @date 2020/12/23 23:53
 */
@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
