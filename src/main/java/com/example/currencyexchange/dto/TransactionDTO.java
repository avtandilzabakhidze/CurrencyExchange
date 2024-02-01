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
    private UserDTO user;
    private double amount;
    private CurrencyDTO fromCurrency;
    private CurrencyDTO toCurrency;
}
