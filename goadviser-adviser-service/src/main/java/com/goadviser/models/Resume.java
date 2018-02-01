package com.goadviser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Resume {

    @NotBlank
    private String education;

    @Field("professional_experience")
    @JsonProperty("professional_experience")
    @NotBlank
    private String professionalExperience;

    @Field("adicional_informations")
    @JsonProperty("adicional_informations")
    @NotBlank
    private String adicionalInformations;
}
