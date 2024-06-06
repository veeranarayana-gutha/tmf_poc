package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactMedium {
    @JsonProperty("@type")
    public String type;
    public Boolean preferred;
    public String mediumType;
    public ValidFor validFor;
    public String emailAddress;
}
