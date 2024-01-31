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
public class SaveCurrency {
    @Id
    @GeneratedValue(generator = "savecurrency_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "savecurrency_id_gen", sequenceName = "savecurrency_id_seq", allocationSize = 1)
    private long id;
    @ManyToOne
    private Currency currency;
    private double totalAmount;
    private double amount;
    private LocalDateTime transactionTime;
}
