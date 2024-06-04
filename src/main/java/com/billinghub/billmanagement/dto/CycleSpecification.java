package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class CycleSpecification {
    @JsonProperty("@type")
    public String type;
    public Integer dateShift;
    public String frequency;
    public String href;
    @Id
    public String id;
    public String name;

}
