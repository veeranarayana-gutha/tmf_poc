package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PresentationMedium {
    @JsonProperty("@type")
    public String type;
    public String href;
    public String id;
    public String name;

}