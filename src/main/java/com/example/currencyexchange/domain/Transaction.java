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
public class Transaction {
    @Id
    @GeneratedValue(generator = "transaction_id_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "transaction_id_gen",sequenceName = "transaction_id_seq",allocationSize = 1)
    private long id;
    @ManyToOne
    private User user;
    private double amount;
    private double takenAmount;
    @ManyToOne
    private Currency fromCurrency;
    @ManyToOne
    private Currency toCurrency;
    private LocalDateTime transactionTime =LocalDateTime.now();
}
