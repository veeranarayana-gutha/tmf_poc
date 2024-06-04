package com.billinghub.billmanagement.dto;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name="value", column = @Column(name ="TotalAmountValue"))
})
public class TotalAmount {
    public String unit;
    public Integer value;
}
