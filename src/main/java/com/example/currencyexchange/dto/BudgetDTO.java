package com.example.currencyexchange.dto;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BudgetDTO {
    private long id;
    @Positive
    private double totalAmount;
}
