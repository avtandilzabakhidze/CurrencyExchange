package com.example.currencyexchange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCurrencyDTO {
    private CurrencyDTO currency;
    private double totalAmount;
    private double amount;
}
