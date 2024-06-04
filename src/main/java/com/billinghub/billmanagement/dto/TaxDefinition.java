package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TaxDefinition {
    @JsonProperty("@type")
    public String type;
    @Id
    @Column(name="taxDefinitionId")
    public String id;
    public String name;
    public String taxType;
}
