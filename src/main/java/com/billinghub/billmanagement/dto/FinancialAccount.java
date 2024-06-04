package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FinancialAccount {
    @JsonProperty("@referredType")
    public String referredType;
    @JsonProperty("@type")
    public String type;
    public String href;
    @Id
    @Column(name ="financialAccountId")
    public String id;
    public String name;

}
