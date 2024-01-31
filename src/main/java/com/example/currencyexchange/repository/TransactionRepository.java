package com.example.currencyexchange.repository;

import com.example.currencyexchange.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {
}
