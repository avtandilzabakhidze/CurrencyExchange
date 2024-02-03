package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.Transaction;
import com.example.currencyexchange.dto.TransactionDTO;
import com.example.currencyexchange.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Get all transactions")
    @GetMapping
    public Iterable<Transaction> getTransaction() {
        return service.getTransaction();
    }

    @Operation(summary = "Add a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    @PostMapping
    public TransactionDTO addTransaction(@RequestBody TransactionDTO transactionDTO) {
        return service.addTransaction(transactionDTO);
    }
}
