package com.example.currencyexchange.repository;

import com.example.currencyexchange.domain.Budget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<Budget,Long> {
    @Query("SELECT COALESCE(SUM(b.amount), 0) FROM Budget b")
    double getCurrentTotalAmount();
}
