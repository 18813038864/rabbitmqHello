package com.rabbitmqHello.rabbitmqHello.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello"+new Date();
        System.out.println("sender:"+context);
        rabbitTemplate.convertAndSend("hello",context);

    }
}
