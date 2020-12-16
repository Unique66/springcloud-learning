/*
 * Copyright (c) 2020.  User:SXH  File:GateWayConfig.java
 * Date:2020/12/16 23:20:16
 */

package com.sxh.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SXH
 * @description GateWayConfig 代码方式添加网关，个人建议配置文件方式实现
 * @date 2020/12/16 23:20
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_bilibili", r -> r.path("/bilibili").uri("https://www.bilibili.com/")).build();
        routes.route("path_route_baidu", r -> r.path("/baidu").uri("https://baike.baidu.com/")).build();
        return routes.build();
    }
}
