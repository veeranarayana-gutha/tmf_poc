package com.billinghub.billmanagement.dto;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
public class AccountRelationship {
    @Id
    @SequenceGenerator(name = "accountRelationshipId",
            sequenceName = "accountRelationshipId",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountRelationshipId"
    )
    public Long accountRelationshipId;
    @JsonProperty("@type")
    public String type;
    public String relationshipType;
    @Embedded
    public ValidFor validFor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="accountId", referencedColumnName = "accountId")
    public Account account;
}
