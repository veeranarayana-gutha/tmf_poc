package com.billinghub.billmanagement.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class Format {
    @JsonProperty("@type")
    public String type;
    public String href;
    public String id;
    public String name;

}
