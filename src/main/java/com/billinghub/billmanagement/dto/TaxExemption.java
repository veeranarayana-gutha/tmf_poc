package com.billinghub.billmanagement.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TaxExemption {
    @JsonProperty("@type")
    public String type;
    public String id;
    public String certificateNumber;
    public String issuingJurisdiction;
    public String reason;
    public List<TaxDefinition> taxDefinition;
    public Attachment attachment;
    public ValidFor validFor;

}
