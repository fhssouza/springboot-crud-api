package com.souzatech.backend.api.model.client;

import com.souzatech.backend.api.enums.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequest{

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private Double monthlyIncome;

    private Gender gender;
    
}
