package com.billinghub.billmanagement.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class BillingPayload {
    @JsonProperty("@type")
    public String type;
    public Long id;
    public String href;
    public String name;
    public String description;
    public String paymentStatus;
    public CreditLimit creditLimit;
    public String state;
    public String accountType;
    public String lastModified;
    public BillStructure billStructure;
    public List<PaymentPlan> paymentPlan;
    public FinancialAccount financialAccount;
    public DefaultPaymentMethod defaultPaymentMethod;
    public List<RelatedParty> relatedParty;
    public List<TaxExemption> taxExemption;
    public List<Contact> contact;
    public List<AccountRelationship> accountRelationship;
}
