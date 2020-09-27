package com.geovis.rabbitmq_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ApiPaymentReceive {
    Logger logger= LoggerFactory.getLogger(ApiPaymentReceive.class);

    @RabbitHandler
    @RabbitListener(queues = "api.payment")
    public void order(String msg) {
        logger.info("api.payment.order receive message: "+msg);
    }
}
