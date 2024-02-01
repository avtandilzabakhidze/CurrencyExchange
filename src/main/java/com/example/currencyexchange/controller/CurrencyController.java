package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.Currency;
import com.example.currencyexchange.dto.CurrencyDTO;
import com.example.currencyexchange.service.CurrencyService;
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

    @GetMapping
    public Iterable<Currency> findAll() {
        return service.findAll();
    }

    @PostMapping
    public CurrencyDTO addCurrency(@RequestBody CurrencyDTO currencyDTO) {
        return service.addCurrency(currencyDTO);
    }
}
