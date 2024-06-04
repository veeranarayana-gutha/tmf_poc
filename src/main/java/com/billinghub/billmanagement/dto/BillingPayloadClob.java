package com.billinghub.billmanagement.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BillingPayloadClob {
    @Id
    public Long id;
    @Lob
    private String billingPayload;
}
