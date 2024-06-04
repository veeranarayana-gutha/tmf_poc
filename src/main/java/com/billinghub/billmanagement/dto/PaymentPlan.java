package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PaymentPlan {
    @Id
    @SequenceGenerator(name = "paymentPlanId",
            sequenceName = "paymentPlanId",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paymentPlanId"
    )
    public Long paymentPlanId;
    @JsonProperty("@type")
    public String type;
    public Integer numberOfPayments;
    public String paymentFrequency;
    public Integer priority;
    public String status;
    @Embedded
    public TotalAmount totalAmount;
    public String paymentType;
    @Embedded
    public ValidFor validFor;
    @Embedded
    public PaymentMethod paymentMethod;

}
