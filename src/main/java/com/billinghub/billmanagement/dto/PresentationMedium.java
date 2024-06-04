package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PresentationMedium {
    @JsonProperty("@type")
    public String type;
    public String href;
    @Id
    public String id;
    public String name;

}
