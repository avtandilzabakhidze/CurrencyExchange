package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.Currency;
import com.example.currencyexchange.dto.CurrencyDTO;
import com.example.currencyexchange.repository.CurrencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private final CurrencyRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public CurrencyService(CurrencyRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Iterable<Currency> findAll() {
        return repository.findAll();
    }

    public CurrencyDTO addCurrency(CurrencyDTO currencyDTO) {
        Currency currency = repository.save(modelMapper.map(currencyDTO, Currency.class));
        return modelMapper.map(currency, CurrencyDTO.class);
    }
}
