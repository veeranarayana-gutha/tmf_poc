package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentPlan {
    @JsonProperty("@type")
    public String type;
    public Integer numberOfPayments;
    public String paymentFrequency;
    public Integer priority;
    public String status;
    public TotalAmount totalAmount;
    public String paymentType;
    public ValidFor validFor;
    public PaymentMethod paymentMethod;

}
