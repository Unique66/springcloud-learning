/*
 * Copyright (c) 2020.  User:SXH  File:PaymentService.java
 * Date:2020/12/15 23:22:15
 */

package com.sxh.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    }) // 超过3 秒，即执行服务降级措施
    public String paymentInfo_TimeOut(Integer id) {
//        int age = 10 / 0; // 出现异常，也执行服务降级

        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id:"
                + id + "\t" + "呜呜 ┭┮﹏┭┮";
    }

    /**
     * 服务调用失败的降级措施
     */
    public String paymentInfo_TimeOut_Handler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试  ,id:"
                + id + "\t" + "o(╥﹏╥)o";
    }


    /**************************************服务熔断*****************************************************/

    /**
     * 服务熔断测试
     * 熔断器有三个状态：open,closed,half-open
     *  1.服务接口正常，熔断器状态时close 的
     *  2.当接口调用失败的条件达到熔断器配置的规则后，熔断器状态变为open，开启期间，
     *    就算服务好了也不让访问（走服务降级），减少响应延迟效果
     *  3.断路器打开后，hystrix 会启动一个休眠时间窗，在这个时间窗内，降级逻辑是临时的主逻辑，当休眠时间窗到期，
     *  熔断器状态变为half-open,释放一次请求到原来主逻辑上，如果此次请求正常返回了，那么就从half-open 变为closed 状态
     *  否则断路器继续进入open 状态，休眠时间重置
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id:" + id;
    }
}
