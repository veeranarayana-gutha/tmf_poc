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


    @GetMapping("/publish")
    public String publishBillingPayload(@RequestParam("message") String message){
        
        billingPayloadPublisher.sendMessage(message);
        return "Message sent successfully";

    }

    @PostMapping("/publish")
    public void publishBillingPayload(@RequestBody BillingPayload message){
    
        try{
            File file = resourceFile.getFile();
            System.out.println(file.toPath());
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       

        System.out.println("publish billpayload..............");
        billingPayloadPublisher.publishMessage(message);

    }
    
    @PostMapping("/publishAsStringAndConsumeAsObject")
    public void publishAsStringAndConsumeAsObject(@RequestBody String message){
    
        try{
            File file = resourceFile.getFile();
            System.out.println(file.toPath());
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       

        System.out.println("publish billpayload..............");
        billingPayloadPublisher.sendMessage(message);

    }

   // public static String asString(Resource resource) {
       // try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
         //   return FileCopyUtils.copyToString(reader);
       // } catch (IOException e) {
       //     throw new UncheckedIOException(e);
        //}
   // }

}
