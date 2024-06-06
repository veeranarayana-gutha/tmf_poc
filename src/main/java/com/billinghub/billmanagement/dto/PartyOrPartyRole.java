package com.billinghub.billmanagement.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PartyOrPartyRole {
    @JsonProperty("@type")
    public String type;
    @JsonProperty("@referredType")
    public String referredType;
    public String href;
    public String id;
    public String name;

}
