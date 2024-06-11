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

    
    @Value("classpath:integrated_payload_scenario1.json")
    Resource integratedResourceFile;

    @Value("classpath:csp_payload_scenario1.json")
    Resource cspBillingHubResourceFile;

    @Value("classpath:disney_payload_scenario1.json")
    Resource disneyBillingHubResourceFile;

    @Value("classpath:netflix_payload_scenario1.json")
    Resource netflixBillingHubResourceFile;

    @GetMapping("/publishCsp")
    public void publishCspPayload() {

        try {
            File file = cspResourceFile.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            billingPayloadPublisher.sendCspMessage(content);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("CSP payload published..............");

    }

    @GetMapping("/publishPartner")
    public void publishPartnerPayload() {

        try {
            File file = partnerResourceFile.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            billingPayloadPublisher.sendPartnerMessage(content);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("partner payload published..............");

    }

    @GetMapping("/publishIntegratedPayload")
    public void publishIntegratedPayload() {

        try {
            File file = integratedResourceFile.getFile();
            String content = new String(Files.readAllBytes(file.toPath()));
            billingPayloadPublisher.sendIntegratedPayloadMessage(content);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("integrated billpayload published..............");

    }

    @GetMapping("/publishBillingHubPayload")
    public void publishBillingHubdPayload() {

        try {
            File cspFile = cspBillingHubResourceFile.getFile();
            String cspPayload = new String(Files.readAllBytes(cspFile.toPath()));
            billingPayloadPublisher.sendBillingHubPayloadMessage(cspPayload);

            File disneyFile = disneyBillingHubResourceFile.getFile();
            String disneyPayload = new String(Files.readAllBytes(disneyFile.toPath()));
            billingPayloadPublisher.sendBillingHubPayloadMessage(disneyPayload);

            File netflixFile = cspBillingHubResourceFile.getFile();
            String netflixPayload = new String(Files.readAllBytes(netflixFile.toPath()));
            billingPayloadPublisher.sendBillingHubPayloadMessage(netflixPayload);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("billinghub payload published..............");

    }

}
