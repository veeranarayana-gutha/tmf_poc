package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RelatedParty {
    public String role;
    @JsonProperty("@type")
    public String type;
    public PartyOrPartyRole partyOrPartyRole;

}
