package com.billinghub.billmanagement.config;

import com.billinghub.billmanagement.common.CSPInfoConverter;
import com.rabbitmq.client.AMQP;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${spring.rabbitmq.queue}")
    private String queueName;

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.routing_key}")
    private String routingKeyName;

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }

    @Bean
    public TopicExchange exchange(){
        return  new TopicExchange(exchangeName) ;
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKeyName);
    }

//    @Bean
//    public MessageConverter converter(){
//        return new Jackson2JsonMessageConverter();
//    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, CSPInfoConverter cspInfoConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(cspInfoConverter);
        return rabbitTemplate;
    }
}
