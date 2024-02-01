package com.example.currencyexchange.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(generator = "currency_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "currency_id_gen", sequenceName = "currency_id_seq", allocationSize = 1)
    private long id;
    @Enumerated(value = EnumType.STRING)
    private CurrencyType currencyType = CurrencyType.GEO;
    @Positive
    private double exchangeRate;
}