package com.example.currencyexchange.repository;

import com.example.currencyexchange.domain.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget,Long> {
}
