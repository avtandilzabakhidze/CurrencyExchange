package com.example.currencyexchange.dto;

import com.example.currencyexchange.domain.CurrencyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDTO {
    private CurrencyType currencyType;
    private double exchangeRate;
}
