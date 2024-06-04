package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ContactMedium {
    @JsonProperty("@type")
    public String type;
    @Id
    @SequenceGenerator(name = "contactMediumId",
            sequenceName = "contactMediumId",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactMediumId"
    )
    public Long contactMediumId;
    public Boolean preferred;
    public String mediumType;
    @Embedded
    public ValidFor validFor;
    public String emailAddress;
}
