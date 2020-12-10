/*
 * Copyright (c) 2020.  User:SXH  File:Payment.java
 * Date:2020/12/10 22:33:10
 */

package com.sxh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author SXH
 * @description Payment 实体
 * @date 2020/12/10 22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
