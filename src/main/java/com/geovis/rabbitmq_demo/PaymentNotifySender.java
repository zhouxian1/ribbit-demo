package com.geovis.rabbitmq_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentNotifySender {
    Logger logger= LoggerFactory.getLogger(PaymentNotifySender.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg){
        logger.info("api.core.user send message: "+msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

    public void userQuery(String msg){
        logger.info("api.core.user.query send message: "+msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }
}
