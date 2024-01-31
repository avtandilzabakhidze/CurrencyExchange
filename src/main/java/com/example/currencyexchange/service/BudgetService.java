package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.Budget;
import com.example.currencyexchange.dto.BudgetDTO;
import com.example.currencyexchange.repository.BudgetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BudgetService {
    private final BudgetRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public BudgetService(BudgetRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
    public Iterable<Budget> getAllBudgets() {
        return repository.findAll();
    }

    public BudgetDTO addBudget(BudgetDTO budgetDTO) {
        Budget author = repository.save(modelMapper.map(budgetDTO, Budget.class));
        return modelMapper.map(author, BudgetDTO.class);
    }

    public BudgetDTO updateBudget(long id, BudgetDTO budgetDTO) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Budget not found with this id : " + id);
        }
        budgetDTO.setId(id);
        Budget budget = repository.save(modelMapper.map(budgetDTO, Budget.class));;
        return modelMapper.map(budget, BudgetDTO.class);
    }
}
