package com.billinghub.billmanagement.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contact {
    @JsonProperty("@type")
    public String type;
    @Id
    @SequenceGenerator(name = "contactId",
            sequenceName = "contactId",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactId"
    )
    public Long contactId;
    public String contactName;
    public String contactType;
    public String partyRoleType;
    @Embedded
    public ValidFor validFor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="contactId", referencedColumnName = "contactId")
    public List<ContactMedium> contactMedium;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="relatedPartyId", referencedColumnName = "relatedPartyId")
    public RelatedParty relatedParty;
}
