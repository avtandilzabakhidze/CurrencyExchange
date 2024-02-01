package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.Transaction;
import com.example.currencyexchange.dto.TransactionDTO;
import com.example.currencyexchange.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    @Autowired
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Transaction> getTransaction() {
        return service.getTransaction();
    }

    @PostMapping
    public TransactionDTO addTransaction(@RequestBody TransactionDTO transactionDTO) {
        return service.addTransaction(transactionDTO);
    }
}
