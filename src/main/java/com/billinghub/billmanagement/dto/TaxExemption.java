package com.billinghub.billmanagement.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TaxExemption {
    @JsonProperty("@type")
    public String type;
    @Id
    @Column(name="taxExemptionId")
    public String id;
    public String certificateNumber;
    public String issuingJurisdiction;
    public String reason;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="taxExemptionId", referencedColumnName = "taxExemptionId")
    public List<TaxDefinition> taxDefinition;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="attachmentId", referencedColumnName = "attachmentId")
    public Attachment attachment;
    @Embedded
    public ValidFor validFor;

}
