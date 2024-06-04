package com.billinghub.billmanagement.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ValidFor {
    public String startDateTime;
    public String endDateTime;
}
