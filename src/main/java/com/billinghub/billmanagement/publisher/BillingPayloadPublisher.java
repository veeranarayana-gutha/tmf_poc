package com.billinghub.billmanagement.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.billinghub.billmanagement.dto.BillingPayload;

@Service
public class BillingPayloadPublisher {

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;// ="e_billing_payload";

    @Value("${spring.rabbitmq.routing_key}")
    private String routingKeyName;//="r_billing_payload";

    private RabbitTemplate rabbitTemplate;

    public BillingPayloadPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }

    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(exchangeName,routingKeyName,message);

    }

    public void publishMessage(BillingPayload message){
        rabbitTemplate.convertAndSend(exchangeName,routingKeyName,message);

    }
}
