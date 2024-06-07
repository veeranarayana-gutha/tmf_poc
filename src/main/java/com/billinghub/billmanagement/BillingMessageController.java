package com.billinghub.billmanagement;


import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.billinghub.billmanagement.dto.BillingPayload;
import com.billinghub.billmanagement.publisher.BillingPayloadPublisher;

@RestController
public class BillingMessageController {


    private BillingPayloadPublisher billingPayloadPublisher;

    

    public BillingMessageController(BillingPayloadPublisher billingPayloadPublisher) {
        this.billingPayloadPublisher = billingPayloadPublisher;
    }

    @Value("classpath:csp.json")
    Resource resourceFile;

    @Value("classpath:partner_disney.json")
    Resource partnerResourceFile;


   

    @GetMapping("/publish")
    public void publishCspPayload(){
    
        try{
            File file = resourceFile.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            billingPayloadPublisher.sendMessage(content);

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
            billingPayloadPublisher.sendMessage(content);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       

        System.out.println("publish billpayload..............");

    }


    @PostMapping("/publishBillingPayload")
    public void publishBillingPayload1(@RequestBody String message){

        System.out.println("publish billpayload..............");
        System.out.println(message);
        billingPayloadPublisher.sendMessage(message);

    }

    
    @PostMapping("/publishAsStringAndConsumeAsObject")
    public void publishAsStringAndConsumeAsObject(@RequestBody String message){
    
        try{
            File file = resourceFile.getFile();
            System.out.println(file.toPath());
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);
            billingPayloadPublisher.sendMessage(content);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       

        System.out.println("publish billpayload..............");
       

    }



}
