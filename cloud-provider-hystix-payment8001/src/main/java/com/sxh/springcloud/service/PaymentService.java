/*
 * Copyright (c) 2020.  User:SXH  File:PaymentService.java
 * Date:2020/12/15 23:22:15
 */

package com.sxh.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author SXH
 * @description PaymentService
 * @date 2020/12/15 23:22
 */
@Service
public class PaymentService {
    /**
     * 成功调用
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  "
                + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 失败，测试服务降级
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000")}) // 超过3 秒，即执行降级措施
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id:"
                + id + "\t" + "呜呜 ┭┮﹏┭┮" + " 耗时(秒)" + timeNumber;
    }

    /**
     * 服务调用失败的降级措施
     */
    public String paymentInfo_TimeOut_Handler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试  ,id:"
                + id + "\t" + "o(╥﹏╥)o";
    }
}
