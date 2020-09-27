package com.geovis.rabbitmq_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiPaymentSender {
    Logger logger= LoggerFactory.getLogger(ApiPaymentSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void order(String msg){
        logger.info("api.payment.order send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order", msg);
    }

    public void orderQuery(String msg){
        logger.info("api.payment.order.query send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg){
        logger.info("api.payment.order.detail.query send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.detail.query", msg);
    }
}
