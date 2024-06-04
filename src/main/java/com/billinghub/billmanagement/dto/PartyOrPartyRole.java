package com.billinghub.billmanagement.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PartyOrPartyRole {
    @JsonProperty("@type")
    public String type;
    @JsonProperty("@referredType")
    public String referredType;
    public String href;
    @Id
    @Column(name="PartyOrPartyRoleId")
    public String id;
    public String name;

}
