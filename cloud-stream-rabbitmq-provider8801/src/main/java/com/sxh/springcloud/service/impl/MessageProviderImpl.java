/*
 * Copyright (c) 2020.  User:SXH  File:MessageProviderImpl.java
 * Date:2020/12/20 01:48:20
 */

package com.sxh.springcloud.service.impl;

import com.sxh.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author SXH
 * @description MessageProviderImpl 消息驱动：消息生产者
 * @date 2020/12/20 1:48
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("*****serial: " + serial);
        return null;
    }
}
