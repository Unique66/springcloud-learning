/*
 * Copyright (c) 2020.  User:SXH  File:HystrixDashboardMain9001.java
 * Date:2020/12/16 01:03:16
 */

package com.sxh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author SXH
 * @description HystrixDashboardMain9001
 * @date 2020/12/16 1:03
 *
 * 监控页面：http://localhost:9001/hystrix
 * 监控服务：http://localhost:8001/hystrix.stream
 * 监控访问接口测试：http://localhost:8001/payment/circuit/3
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
