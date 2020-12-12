/*
 * Copyright (c) 2020.  User:SXH  File:PaymentDao.java
 * Date:2020/12/10 22:40:10
 */

package com.sxh.springcloud.dao;

import com.sxh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author SXH
 * @description PaymentDao
 * @date 2020/12/10 22:40
 */
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
