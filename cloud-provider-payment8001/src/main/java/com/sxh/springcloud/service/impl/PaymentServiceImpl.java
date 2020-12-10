/*
 * Copyright (c) 2020.  User:SXH  File:PaymentServiceImpl.java
 * Date:2020/12/10 23:20:10
 */

package com.sxh.springcloud.service.impl;

import com.sxh.springcloud.dao.PaymentDao;
import com.sxh.springcloud.entities.Payment;
import com.sxh.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description PaymentServiceImpl
 * @date 2020/12/10 23:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
