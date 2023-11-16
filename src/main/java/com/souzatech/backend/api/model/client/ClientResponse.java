package com.souzatech.backend.api.model.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.souzatech.backend.api.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonPropertyOrder({
        "id",
        "name",
        "cpf",
        "birthday",
        "monthlyIncome",
        "gender",
})
public class ClientResponse {

    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("Birth Date")
    private LocalDate birthDate;

    @JsonProperty("Monthly Income")
    private Double monthlyIncome;

    @JsonProperty("Gender")
    private Gender gender;
    
}
