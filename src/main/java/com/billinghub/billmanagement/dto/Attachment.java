package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Attachment {
    @JsonProperty("@type")
    public String type;
    @Id
    @Column(name="attachmentId")
    public String id;
    public String href;
    public String attachmentType;
    public String name;
    public String description;
    public String mimeType;
    public String url;

}
