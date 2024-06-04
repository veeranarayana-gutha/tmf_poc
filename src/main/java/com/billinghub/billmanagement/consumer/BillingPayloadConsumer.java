package com.billinghub.billmanagement.consumer;

import com.billinghub.billmanagement.dto.BillingPayload;
import com.billinghub.billmanagement.dto.BillingPayloadClob;
import com.billinghub.billmanagement.repository.BillingPayloadClobRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billinghub.billmanagement.repository.BillingPayloadRepository;

@Service
public class BillingPayloadConsumer {

    @Autowired
    private BillingPayloadRepository billingPayloadRepository;

    @Autowired
    private BillingPayloadClobRepository billingPayloadClobRepository;


    @RabbitListener(queues ="${spring.rabbitmq.queue}")
    public void processBillingPayload(BillingPayload message) {
        //For now used BillingPayload object String , to insert as Clob later directly
       // use the json String
        System.out.println(message.toString());
        //Logic to insert data in clob table
        BillingPayloadClob billingPayloadClob = new BillingPayloadClob();
        billingPayloadClob.setId(message.getId());
        billingPayloadClob.setBillingPayload(message.toString());
        billingPayloadClobRepository.save(billingPayloadClob);

        //logic to map the billing data to appropriate table
        billingPayloadRepository.save(message);
    }


}
