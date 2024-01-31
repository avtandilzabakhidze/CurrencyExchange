package com.example.currencyexchange.dto;

import com.example.currencyexchange.domain.Currency;
import com.example.currencyexchange.domain.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDTO {
    private long id;
    private UserDTO user;
    private double amount;
    private double takenAmount;
    private CurrencyDTO fromCurrency;
    private CurrencyDTO toCurrency;
    private LocalDateTime transactionTime;
}
