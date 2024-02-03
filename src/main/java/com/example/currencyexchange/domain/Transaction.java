package com.example.currencyexchange.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(generator = "transaction_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "transaction_id_gen", sequenceName = "transaction_id_seq", allocationSize = 1)
    private long id;
    @JsonBackReference
    @ManyToOne( fetch = FetchType.LAZY)
    private User user;
    private double amount;
    private double takenAmount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Currency fromCurrency;
    @ManyToOne(cascade = CascadeType.ALL)
    private Currency toCurrency;
    private LocalDateTime transactionTime = LocalDateTime.now();
}
