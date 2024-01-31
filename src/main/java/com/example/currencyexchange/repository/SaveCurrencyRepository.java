package com.example.currencyexchange.repository;

import com.example.currencyexchange.domain.SaveCurrency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveCurrencyRepository extends CrudRepository<SaveCurrency, Long> {
}
