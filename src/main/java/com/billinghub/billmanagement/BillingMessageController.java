package com.billinghub.billmanagement;


import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.billinghub.billmanagement.publisher.BillingPayloadPublisher;

@RestController
public class BillingMessageController {


    private BillingPayloadPublisher billingPayloadPublisher;



    public BillingMessageController(BillingPayloadPublisher billingPayloadPublisher) {
        this.billingPayloadPublisher = billingPayloadPublisher;
    }

    @Value("classpath:csp.json")
    Resource cspResourceFile;

    @Value("classpath:partner_disney.json")
    Resource partnerResourceFile;


    @GetMapping("/publishCsp")
    public void publishCspPayload(){

        try{
            File file = cspResourceFile.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            billingPayloadPublisher.sendCspMessage(content);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("publish billpayload..............");

    }

    @GetMapping("/publishPartner")
    public void publishPartnerPayload(){

        try{
            File file = partnerResourceFile.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            billingPayloadPublisher.sendPartnerMessage(content);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println("publish billpayload..............");

    }

}
