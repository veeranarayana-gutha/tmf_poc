package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CycleSpecification {
    @JsonProperty("@type")
    public String type;
    public Integer dateShift;
    public String frequency;
    public String href;
    public String id;
    public String name;

}
