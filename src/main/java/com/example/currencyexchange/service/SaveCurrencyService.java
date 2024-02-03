package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.SaveCurrency;
import com.example.currencyexchange.dto.SaveCurrencyDTO;
import com.example.currencyexchange.repository.SaveCurrencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveCurrencyService {
    private final SaveCurrencyRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public SaveCurrencyService(SaveCurrencyRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Iterable<SaveCurrency> findAll() {
        return repository.findAll();
    }

}
