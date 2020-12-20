/*
 * Copyright (c) 2020.  User:SXH  File:ReceiveMessageListenerController.java
 * Date:2020/12/20 01:59:20
 */

package com.sxh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author SXH
 * @description ReceiveMessageListenerController
 * @date 2020/12/20 1:59
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1号，接受：" + message.getPayload() + "\t port:" + serverPort);
    }
}
