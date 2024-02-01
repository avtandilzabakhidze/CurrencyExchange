package com.example.currencyexchange.dto;

import com.example.currencyexchange.domain.Currency;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SaveCurrencyDTO {
    private CurrencyDTO currency;
    private double totalAmount;
    private double amount;
}
