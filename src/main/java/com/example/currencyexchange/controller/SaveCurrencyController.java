package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.SaveCurrency;
import com.example.currencyexchange.dto.SaveCurrencyDTO;
import com.example.currencyexchange.service.SaveCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("saveCurrencies")
public class SaveCurrencyController {
    private final SaveCurrencyService service;

    @Autowired
    public SaveCurrencyController(SaveCurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<SaveCurrency> findAll() {
        return service.findAll();
    }

    @PostMapping
    public SaveCurrencyDTO addSaveCurrency(@RequestBody SaveCurrencyDTO saveCurrencyDTO) {
        return service.addSaveCurrency(saveCurrencyDTO);
    }
}
