package com.billinghub.billmanagement.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.billinghub.billmanagement.dto.BillingPayload;
import com.billinghub.billmanagement.repository.BillingPayloadRepository;

@Service
public class BillingPayloadConsumer {

    @Autowired
    private BillingPayloadRepository billingPayloadRepository;


    //@RabbitListener(queues ={"q_billing_payload"})
    public void processBillingPayload(String message){

        System.out.println("Consumer recieved message - "+message);
       // billingPayloadRepository.save(message);

    }

    @RabbitListener(queues ="${spring.rabbitmq.queue}")
    public void processBillingPayload(BillingPayload message){

       // System.out.println(test);
        System.out.println(message.toString());
        billingPayloadRepository.save(message);

    }


}
