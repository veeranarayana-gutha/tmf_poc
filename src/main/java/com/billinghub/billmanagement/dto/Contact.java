package com.billinghub.billmanagement.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Contact {
    @JsonProperty("@type")
    public String type;
    public String contactName;
    public String contactType;
    public String partyRoleType;
    public ValidFor validFor;
    public List<ContactMedium> contactMedium;
    public RelatedParty relatedParty;
}
