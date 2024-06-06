package com.billinghub.billmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Attachment {
    @JsonProperty("@type")
    public String type;
    public String id;
    public String href;
    public String attachmentType;
    public String name;
    public String description;
    public String mimeType;
    public String url;

}
