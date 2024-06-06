package com.billinghub.billmanagement.consumer;

import com.billinghub.billmanagement.dto.BillingPayload;
import com.billinghub.billmanagement.dto.CspInfo;
import com.billinghub.billmanagement.repository.CspInfoRepository;
import com.billinghub.billmanagement.util.JsonUtil;
import com.google.gson.JsonSyntaxException;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingPayloadConsumer {
     @Autowired
     private CspInfoRepository cspInfoRepository;


    @RabbitListener(queues ="${spring.rabbitmq.queue}")
    public void processBillingPayload(String message) {
        System.out.println("Message Received : -----------------------------------");
        System.out.println(message);
        System.out.println("-------------------------------------------------------");
        try {
            if (StringUtils.isNotBlank(message)) {
                BillingPayload  billingPayload = JsonUtil.convertJsonToTargetPojoObject(message, BillingPayload.class);
                if (billingPayload != null) {
                    //set all the required fields into specific tables based on condition
                        CspInfo cspInfo = new CspInfo();
                        cspInfo.setJson(message);
                        cspInfo.setCspId(billingPayload.getId());
                        cspInfo.setCspName(billingPayload.getName());
                        cspInfoRepository.save(cspInfo);
                }
            }
        }catch(JsonSyntaxException e) {
            System.out.println("Message Parsing Failed:" + e.getMessage());
        }catch(Exception e){
            System.out.println("Exception occured while processing the event" + e.getMessage());
        }
    }


}
