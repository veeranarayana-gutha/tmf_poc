package com.billinghub.billmanagement.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BillingPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    private String billNo;

    private String category;

    private String runNumber;

    private String state;

    private String amount;

    
}
