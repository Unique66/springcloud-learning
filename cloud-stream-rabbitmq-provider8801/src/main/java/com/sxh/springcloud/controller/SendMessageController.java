/*
 * Copyright (c) 2020.  User:SXH  File:SendMessageController.java
 * Date:2020/12/20 01:53:20
 */

package com.sxh.springcloud.controller;

import com.sxh.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author SXH
 * @description SendMessageController
 * @date 2020/12/20 1:53
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
