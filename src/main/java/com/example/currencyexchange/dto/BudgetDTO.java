package com.example.currencyexchange.dto;

import com.example.currencyexchange.domain.TransactionType;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetDTO {
    @Positive
    private double amount;
    private TransactionType transactionType;
}
