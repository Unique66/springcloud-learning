/*
 * Copyright (c) 2020.  User:SXH  File:PaymentService.java
 * Date:2020/12/10 23:19:10
 */

package com.sxh.springcloud.service;

import com.sxh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author SXH
 * @description PaymentService
 * @date 2020/12/10 23:19
 */
public interface PaymentService {
    int create(Payment payment); // 写
    Payment getPaymentById(@Param("id") Long id);  // 读取
}
