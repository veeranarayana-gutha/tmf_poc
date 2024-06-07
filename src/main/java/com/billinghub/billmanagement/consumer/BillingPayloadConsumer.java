package com.billinghub.billmanagement.consumer;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billinghub.billmanagement.model.CSPInfo;
import com.billinghub.billmanagement.model.PartnerInfo;
import com.billinghub.billmanagement.repository.PartnerInfoRepository;
import com.billinghub.billmanagement.repository.CSPInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BillingPayloadConsumer {

 
    @Autowired
    private CSPInfoRepository cspInfoRepository;

    @Autowired
    private PartnerInfoRepository partnerInfoRepository;


    
   // @RabbitListener(queues ="${spring.rabbitmq.queue}")
    public void processBillingPayload(String message){
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            	JsonNode rootNode = objectMapper.readTree(message);
            	CSPInfo cspInfo = new CSPInfo();
            	Optional.ofNullable(rootNode.get("id")).map(JsonNode::asText).ifPresent(cspInfo::setCspId);
            	Optional.ofNullable(rootNode.get("name")).map(JsonNode::asText).ifPresent(cspInfo::setCspName);
                Optional.ofNullable(rootNode.get("creditLimit")).map(x->x.get("value")).map(JsonNode::asText).ifPresent(cspInfo::setCreditAmount);
                Optional.ofNullable(rootNode.get("paymentStatus")).map(JsonNode::asText).ifPresent(cspInfo::setStatus);
                
                cspInfo.setCreateDate(java.time.LocalDateTime.now().toString());
            	cspInfo.setJson(message);

            System.out.println(message.toString());
            cspInfoRepository.save(cspInfo);
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

        @RabbitListener(queues ="${spring.rabbitmq.queue}")
        public void processPartnerPayload(String message){
            try {
                ObjectMapper objectMapper = new ObjectMapper();
    
                    JsonNode rootNode = objectMapper.readTree(message);
                    PartnerInfo partnerInfo = new PartnerInfo();
                    Optional.ofNullable(rootNode.get("id")).map(JsonNode::asText).ifPresent(partnerInfo::setPartnerId);
                    Optional.ofNullable(rootNode.get("name")).map(JsonNode::asText).ifPresent(partnerInfo::setPartnerName);
                    Optional.ofNullable(rootNode.get("creditLimit")).map(x->x.get("value")).map(JsonNode::asText).ifPresent(partnerInfo::setCreditAmount);
                    Optional.ofNullable(rootNode.get("paymentStatus")).map(JsonNode::asText).ifPresent(partnerInfo::setStatus);
                    
                    partnerInfo.setCreateDate(java.time.LocalDateTime.now().toString());
                    partnerInfo.setJson(message);
    
                System.out.println(message.toString());
                partnerInfoRepository.save(partnerInfo);
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }


}
