package com.billinghub.billmanagement.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class AccountRelationship {
    @JsonProperty("@type")
    public String type;
    public String relationshipType;
    public ValidFor validFor;
    public Account account;
}
