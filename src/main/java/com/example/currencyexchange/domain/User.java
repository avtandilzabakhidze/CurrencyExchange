package com.example.currencyexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "user_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
    private long id;
    private String personalNO;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private long phoneNumber;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
