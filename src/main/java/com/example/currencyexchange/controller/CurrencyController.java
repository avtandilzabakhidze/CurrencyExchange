package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.Currency;
import com.example.currencyexchange.dto.CurrencyDTO;
import com.example.currencyexchange.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("currencies")
public class CurrencyController {
    private final CurrencyService service;

    @Autowired
    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @Operation(summary = "Get all currencies")
    @GetMapping
    public Iterable<Currency> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Add a new currency")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    @PostMapping
    public CurrencyDTO addCurrency(@RequestBody CurrencyDTO currencyDTO) {
        return service.addCurrency(currencyDTO);
    }}
