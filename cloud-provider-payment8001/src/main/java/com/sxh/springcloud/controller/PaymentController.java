/*
 * Copyright (c) 2020.  User:SXH  File:PaymentController.java
 * Date:2020/12/10 23:22:10
 */

package com.sxh.springcloud.controller;

import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import com.sxh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****insert result:" + result);
        if (result > 0) {  // 成功
            return new CommonResult(200, "insert db success. serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "insert db failed. serverPort:" + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****search result:" + payment);
        if (payment != null) {  // 说明有数据，能查询成功
            return new CommonResult(200, "search success. serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "no record, search id:" + id + " serverPort:" + serverPort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 测试OpenFeign 超时控制，提供一个超时接口
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }

    /**
     * 测试Sleuth 分布式请求链路跟踪   zipkin+sleuth
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to bilibili，O(∩_∩)O哈哈~";
    }

}
