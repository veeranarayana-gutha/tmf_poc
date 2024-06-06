package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class BillStructure {
    @JsonProperty("@type")
    public String type;
    public List<PresentationMedium> presentationMedia;
    public Format format;
    public CycleSpecification cycleSpecification;

}
