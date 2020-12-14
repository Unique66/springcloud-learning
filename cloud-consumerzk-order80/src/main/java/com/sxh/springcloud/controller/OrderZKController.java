/*
 * Copyright (c) 2020.  User:SXH  File:OrderZKController.java
 * Date:2020/12/14 21:47:14
 */

package com.sxh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description OrderZKController
 * @date 2020/12/14 21:47
 */

@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOME_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment() {
        String result = restTemplate.getForObject(INVOME_URL + "/payment/zk", String.class);
        return result;
    }
}
