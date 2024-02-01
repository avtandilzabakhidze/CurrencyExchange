package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.Transaction;
import com.example.currencyexchange.domain.User;
import com.example.currencyexchange.dto.TransactionDTO;
import com.example.currencyexchange.dto.UserDTO;
import com.example.currencyexchange.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionService(TransactionRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Iterable<Transaction> getTransaction() {
        return repository.findAll();
    }

    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = repository.save(modelMapper.map(transactionDTO, Transaction.class));
        return modelMapper.map(transaction, TransactionDTO.class);
    }
}
