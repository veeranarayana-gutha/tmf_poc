package com.billinghub.billmanagement.config;

import com.rabbitmq.client.AMQP;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfig {

    @Value("${spring.rabbitmq.csp.queue}")
    private String cspQueueName;

    @Value("${spring.rabbitmq.partner.queue}")
    private String partnerQueueName;

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.csp.routing_key}")
    private String cspRoutingKeyName;

    @Value("${spring.rabbitmq.partner.routing_key}")
    private String partnerRoutingKeyName;

    @Bean
    public Queue cspQueue(){
        return new Queue(cspQueueName);
    }

    @Bean
    public Queue partnerQueue(){
        return new Queue(partnerQueueName);
    }

    @Bean
    public TopicExchange exchange(){
        return  new TopicExchange(exchangeName) ;
    }

    @Bean
    public Binding cspBinding(){
        return BindingBuilder.bind(cspQueue()).to(exchange()).with(cspRoutingKeyName);
    }


    @Bean
    public Binding partnerBinding(){
        return BindingBuilder.bind(partnerQueue()).to(exchange()).with(partnerRoutingKeyName);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }
}
