package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.Budget;
import com.example.currencyexchange.domain.SaveCurrency;
import com.example.currencyexchange.domain.Transaction;
import com.example.currencyexchange.domain.TransactionType;
import com.example.currencyexchange.dto.TransactionDTO;
import com.example.currencyexchange.repository.BudgetRepository;
import com.example.currencyexchange.repository.SaveCurrencyRepository;
import com.example.currencyexchange.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository repository;
    private final BudgetRepository budgetRepository;
    private final SaveCurrencyRepository saveCurrencyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionService(TransactionRepository repository, BudgetRepository budgetRepository, SaveCurrencyRepository saveCurrencyRepository, ModelMapper modelMapper) {
        this.repository = repository;
        this.budgetRepository = budgetRepository;
        this.saveCurrencyRepository = saveCurrencyRepository;
        this.modelMapper = modelMapper;
    }

    public Iterable<Transaction> getTransaction() {
        return repository.findAll();
    }

    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = repository.save(modelMapper.map(transactionDTO, Transaction.class));

        double currentTotalAmount = budgetRepository.getCurrentTotalAmount();
        currentTotalAmount -= transactionDTO.getAmount();

        Budget budget = new Budget();
        budget.setAmount(transactionDTO.getAmount());
        budget.setTransactionType(TransactionType.EXIT);
        budget.setTotalAmount(currentTotalAmount);

        SaveCurrency saveCurrency = new SaveCurrency();
        saveCurrency.setAmount(transactionDTO.getAmount());
        Transaction mapped = modelMapper.map(transactionDTO, Transaction.class);
        saveCurrency.setCurrency(mapped.getToCurrency());
        double takenAmount = mapped.getAmount() / mapped.getToCurrency().getExchangeRate();
        saveCurrency.setTotalAmount(takenAmount);
        repository.save(transaction);
        budgetRepository.save(budget);
        saveCurrencyRepository.save(saveCurrency);
        return modelMapper.map(transaction, TransactionDTO.class);
    }
}
