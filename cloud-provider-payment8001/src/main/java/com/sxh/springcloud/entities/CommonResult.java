/*
 * Copyright (c) 2020.  User:SXH  File:CommonResult.java
 * Date:2020/12/10 22:35:10
 */

package com.sxh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SXH
 * @description 接口通用返回结果
 * @date 2020/12/10 22:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
