package com.example.currencyexchange.dto;

import com.example.currencyexchange.domain.Transaction;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String personalNO;
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private long phoneNumber;
    private String email;
    private List<TransactionDTO> transactions;
}
