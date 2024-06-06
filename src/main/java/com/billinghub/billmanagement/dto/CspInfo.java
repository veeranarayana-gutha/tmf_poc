package com.billinghub.billmanagement.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CspInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Long cspId;
    private String cspName;
    private Long customerId;
    private String customer;
    private String customerCspBillAccount;
    private String eventType;
    private String status;
    private String createDate;
    @Lob
    private String json;
}
