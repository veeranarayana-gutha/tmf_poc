package com.billinghub.billmanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class PartnerInfo {
    @Id
    private Long partnerId;
    private String partnerName;
    private Long customerId;
    private String customer;
    private String customerPartnerBillAccount;
    private String eventType;
    private String status;
    private String createDate;
    @Lob
    private String json;
}
