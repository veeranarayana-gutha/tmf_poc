package com.billinghub.billmanagement.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name="id",column = @Column(name="paymentMethodId")),
        @AttributeOverride(name="type",column = @Column(name="PaymentMethodType"))
})
public class PaymentMethod {

    @JsonProperty("@type")
    public String type;
    public String href;
    public String id;
    public String name;

}
