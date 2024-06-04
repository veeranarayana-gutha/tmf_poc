package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RelatedParty {
    @Id
    @SequenceGenerator(name = "relatedPartyId",
            sequenceName = "relatedPartyId",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "relatedPartyId"
    )
    public Long relatedPartyId;
    public String role;
    @JsonProperty("@type")
    public String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="PartyOrPartyRoleId", referencedColumnName = "PartyOrPartyRoleId")
    public PartyOrPartyRole partyOrPartyRole;

}
