package com.goadviser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Financial {

    @Field("receive_date")
    @JsonProperty("receive_date")
    @NotBlank
    private String receiveDate;

    @Field("amount_receive")
    @JsonProperty("amount_receive")
    private Double amountReceive = 0.0;
}
