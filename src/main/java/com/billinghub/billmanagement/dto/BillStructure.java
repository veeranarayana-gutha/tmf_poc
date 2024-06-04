package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillStructure {
    @JsonProperty("@type")
    public String type;
    @Id
    @SequenceGenerator(name = "billStructureId",
      sequenceName = "billStructureId",
      initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "billStructureId"
    )
    public Long billStructureId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="billStructureId", referencedColumnName = "billStructureId")
    public List<PresentationMedium> presentationMedia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="formatId", referencedColumnName = "id")
    public Format format;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="cycleSpecificationId", referencedColumnName = "id")
    public CycleSpecification cycleSpecification;

}
