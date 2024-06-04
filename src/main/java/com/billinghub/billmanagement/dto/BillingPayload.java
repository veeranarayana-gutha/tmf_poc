package com.billinghub.billmanagement.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingPayload {
    @JsonProperty("@type")
    public String type;
    @Id
    public Long id;
    public String href;
    public String name;
    public String description;
    public String paymentStatus;
    @Embedded
    public CreditLimit creditLimit;
    public String state;
    public String accountType;
    public String lastModified;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="billStructureId", referencedColumnName = "billStructureId")
    public BillStructure billStructure;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id", referencedColumnName = "id")
    public List<PaymentPlan> paymentPlan;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="financialAccountId", referencedColumnName = "financialAccountId")
    public FinancialAccount financialAccount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="defaultPaymentMethodId", referencedColumnName = "defaultPaymentMethodId")
    public DefaultPaymentMethod defaultPaymentMethod;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id", referencedColumnName = "id")
    public List<RelatedParty> relatedParty;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id", referencedColumnName = "id")
    public List<TaxExemption> taxExemption;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id", referencedColumnName = "id")
    public List<Contact> contact;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="id", referencedColumnName = "id")
    public List<AccountRelationship> accountRelationship;
}
