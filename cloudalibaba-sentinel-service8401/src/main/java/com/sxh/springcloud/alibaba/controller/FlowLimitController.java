/*
 * Copyright (c) 2020.  User:SXH  File:FlowLimitController.java
 * Date:2020/12/23 22:06:23
 */

package com.sxh.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author SXH
 * @description FlowLimitController 测试sentinel 配置
 * @date 2020/12/23 22:05
 */
@RestController
@Slf4j
public class FlowLimitController {
    /**
     * 流控规则
     */
    @GetMapping("/testA")
    public String testA() {
        // testA 和testB 可以测试流控规则、降级规则配置
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }


    /**
     * 降级规则
     */
    @GetMapping("/testD")
    public String testD() {
        log.info("testD 测试RT慢调用比例降级"); //RT -> 平均响应时间
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常比例、异常数降级");
        int age = 10 / 0; // 测试异常比例降级
        return "------testE";
    }

    /**
     * 热点规则
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        // http://localhost:8401/testHotKey?p2=2
        // 热点规则限制第二个参数
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }
}
