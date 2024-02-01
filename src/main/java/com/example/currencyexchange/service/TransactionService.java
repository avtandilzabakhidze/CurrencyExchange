package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.Budget;
import com.example.currencyexchange.domain.Transaction;
import com.example.currencyexchange.domain.TransactionType;
import com.example.currencyexchange.dto.BudgetDTO;
import com.example.currencyexchange.dto.TransactionDTO;
import com.example.currencyexchange.repository.BudgetRepository;
import com.example.currencyexchange.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository repository;
    private final BudgetRepository budgetRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionService(TransactionRepository repository, BudgetRepository budgetRepository, ModelMapper modelMapper) {
        this.repository = repository;
        this.budgetRepository = budgetRepository;
        this.modelMapper = modelMapper;
    }

    public Iterable<Transaction> getTransaction() {
        return repository.findAll();
    }

    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = repository.save(modelMapper.map(transactionDTO, Transaction.class));
        double currentTotalAmount = budgetRepository.getCurrentTotalAmount();
        currentTotalAmount -= transactionDTO.getAmount();
        System.out.println("currntTotalAmount" + currentTotalAmount);

        Budget budget = new Budget();
        budget.setAmount(transactionDTO.getAmount());
        budget.setTransactionType(TransactionType.EXIT);
        budget.setTotalAmount(currentTotalAmount);

        try {
            repository.save(transaction);
            budgetRepository.save(budget);
            // Commit the transaction
        } catch (Exception e) {
            // Rollback the transaction if an exception occurs
        }
        return modelMapper.map(transaction, TransactionDTO.class);
    }
}
