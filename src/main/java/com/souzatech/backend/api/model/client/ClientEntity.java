package com.souzatech.backend.api.model.client;

import com.souzatech.backend.api.enums.Gender;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
@Data
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    private String name;

    @Column(length = 15, nullable = false)
    private String cpf;

    @Column(name="dt_nascimento", nullable = false)
    private LocalDate birthDate;

    @Column(name="renda_mensal", nullable = false, length = 9, precision = 2)
    private Double monthlyIncome;

    @Enumerated(EnumType.STRING)
    @Column(name="genero", nullable = false, length = 10)
    private Gender gender;
    
}
