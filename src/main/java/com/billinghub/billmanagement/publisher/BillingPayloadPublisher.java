package com.billinghub.billmanagement.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class BillingPayloadPublisher {

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.csp.routing_key}")
    private String cspRoutingKeyName;

    @Value("${spring.rabbitmq.partner.routing_key}")
    private String partnerRoutingKeyName;

    private RabbitTemplate rabbitTemplate;

    public BillingPayloadPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendCspMessage(String message){
        rabbitTemplate.convertAndSend(exchangeName,cspRoutingKeyName,message);

    }

    public void sendPartnerMessage(String message){
        rabbitTemplate.convertAndSend(exchangeName,partnerRoutingKeyName,message);

    }
}
