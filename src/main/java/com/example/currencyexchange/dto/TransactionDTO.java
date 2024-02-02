package com.example.currencyexchange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {
    private long userId;
    private double amount;
    private CurrencyDTO fromCurrency;
    private CurrencyDTO toCurrency;
}
