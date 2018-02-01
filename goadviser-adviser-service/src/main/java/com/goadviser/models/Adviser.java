package com.goadviser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(collection = "advisers")
public class Adviser {

    @Id
    @JsonProperty("_id")
    private String id;

    @Indexed(name = "name")
    @NotBlank
    @Size(min = 3)
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Field("is_online")
    @JsonProperty("is_online")
    private Boolean isOnline = false;

    private String photo;

    @Field("price_consulting_video")
    @JsonProperty("price_consulting_video")
    private Double priceConsultingVideo = 0.0;

    @Field("price_consulting_voice")
    @JsonProperty("price_consulting_voice")
    private Double priceConsultingVoice = 0.0;

    @Field("price_consulting_text")
    @JsonProperty("price_consulting_text")
    private Double priceConsultingText = 0.0;

    private Resume resume;

    private List<Financial> financials;

    @Field("created_at")
    @JsonProperty("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
