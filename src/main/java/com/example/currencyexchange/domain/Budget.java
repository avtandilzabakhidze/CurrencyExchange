package com.example.currencyexchange.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(generator = "budget_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "budget_id_gen", sequenceName = "budget_id_seq", allocationSize = 1)
    private long id;
    private double totalAmount;
    private LocalDateTime transactionTime = LocalDateTime.now();
}
