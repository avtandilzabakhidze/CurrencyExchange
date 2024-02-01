package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.Budget;
import com.example.currencyexchange.domain.TransactionType;
import com.example.currencyexchange.dto.BudgetDTO;
import com.example.currencyexchange.repository.BudgetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    private final BudgetRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public BudgetService(BudgetRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Iterable<Budget> getAllBudgets() {
        return repository.findAll();
    }

    public BudgetDTO addBudget(BudgetDTO budgetDTO) {
        double currentTotalAmount = repository.getCurrentTotalAmount();

        if (budgetDTO.getTransactionType() == TransactionType.INCOME) {
            currentTotalAmount += budgetDTO.getAmount();
        } else {
            if (budgetDTO.getAmount() > currentTotalAmount) {
                //TODO incorrect error
                throw new IllegalArgumentException("Insufficient funds: cannot spend more than current total amount .this is :" + budgetDTO.getAmount());
            } else {
                currentTotalAmount -= budgetDTO.getAmount();
            }
        }
        Budget budget = new Budget();
        budget.setAmount(budgetDTO.getAmount());
        budget.setTransactionType(budgetDTO.getTransactionType());
        budget.setTotalAmount(currentTotalAmount);
        Budget savedBudget = repository.save(budget);

        return modelMapper.map(savedBudget, BudgetDTO.class);
    }

}
