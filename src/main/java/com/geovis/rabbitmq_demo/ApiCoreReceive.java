package com.geovis.rabbitmq_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ApiCoreReceive {
    Logger logger= LoggerFactory.getLogger(ApiCoreReceive.class);
    @RabbitHandler
    @RabbitListener(queues = "api.core")
    public void user(String msg) {
        logger.info("api.core receive message: "+msg);
    }
}
