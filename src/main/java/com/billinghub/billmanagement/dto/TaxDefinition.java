package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TaxDefinition {
    @JsonProperty("@type")
    public String type;
    public String id;
    public String name;
    public String taxType;
}
