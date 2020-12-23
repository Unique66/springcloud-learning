/*
 * Copyright (c) 2020.  User:SXH  File:CircleBreakerController.java
 * Date:2020/12/23 23:26:23
 */

package com.sxh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sxh.springcloud.alibaba.service.PaymentService;
import com.sxh.springcloud.entities.CommonResult;
import com.sxh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description CircleBreakerController 测试服务熔断 sentinel
 * @date 2020/12/23 23:26
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 测试：对 fallback 添加流控规则
     * 测试exceptionsToIgnore: http://localhost:83/consumer/fallback/4
     *  现象：不到流控规则范围时，由于忽略次异常的抛出，页面报500，不友好；不过到流控规则范围后，会走blockHandler 限制
     * 测试正常调用，没有异常： http://localhost:83/consumer/fallback/1
     *  现象：没有到流控规则时：正常访问   到流控规则后：走blockHandler 规则
     * 测试异常调用： http://localhost:83/consumer/fallback/5
     *  现象：没有到流控规则时：走fallback 配置（自定义降级）  到流控规则后：走blockHandler 规则
     */
    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") // 没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") // fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") // blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    // fallback
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,
                "兜底异常handlerFallback,exception内容  " + e.getMessage(), payment);
    }

    // blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445,
                "blockHandler-sentinel限流,无此流水: blockException  "
                        + blockException.getMessage(), payment);
    }


    /********************************* OpenFeign ************************/
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
