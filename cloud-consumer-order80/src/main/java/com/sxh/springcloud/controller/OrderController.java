/*
 * Copyright (c) 2020.  User:SXH  File:OrderController.java
 * Date:2020/12/12 17:17:12
 */

package com.sxh.springcloud.controller;

import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description OrderController
 * @date 2020/12/12 17:17
 */
@RestController
@Slf4j
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001"; // 单机
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // 使用注册中心的服务

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentByEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("status code:{}", entity.getStatusCode() + "\t");
            return entity.getBody();
        } else {
            return new CommonResult<Payment>(444, "operate failed", null);
        }
    }

    /**
     * 测试Sleuth 分布式请求链路跟踪   zipkin+sleuth
     */
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/", String.class);
        return result;
    }
}
