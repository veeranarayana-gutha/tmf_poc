package com.billinghub.billmanagement.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class BillingPayloadPublisher {

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeKey;

    @Value("${spring.rabbitmq.csp.routing_key}")
    private String cspRoutingKey;

    @Value("${spring.rabbitmq.partner.routing_key}")
    private String partnerRoutingKey;

   @Value("${spring.rabbitmq.integration.routing_key}") 
    private String integrationRoutingKey;

    @Value("${spring.rabbitmq.billingHub.routing_key}")
    private String billingHubRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public BillingPayloadPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendCspMessage(String message){
        rabbitTemplate.convertAndSend(exchangeKey,cspRoutingKey,message);

    }

    public void sendPartnerMessage(String message){
        rabbitTemplate.convertAndSend(exchangeKey,partnerRoutingKey,message);

    }

    public void sendIntegratedPayloadMessage(String message){
        rabbitTemplate.convertAndSend(exchangeKey,integrationRoutingKey,message);

    }

    public void sendBillingHubPayloadMessage(String message){
        rabbitTemplate.convertAndSend(exchangeKey,billingHubRoutingKey,message);

    }
}
