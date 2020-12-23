/*
 * Copyright (c) 2020.  User:SXH  File:CustomerBlockHandler.java
 * Date:2020/12/23 22:49:23
 */

package com.sxh.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sxh.springcloud.entities.CommonResult;

/**
 * @author SXH
 * @description CustomerBlockHandler
 * @date 2020/12/23 22:49
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020,
                "自定义限流处理信息....CustomerBlockHandler");
    }

    /**
     * 两个方法，表明通过方法来指定降级响应
     */
    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020,
                "自定义限流处理信息....CustomerBlockHandler--222");
    }
}
