package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.Budget;
import com.example.currencyexchange.dto.BudgetDTO;
import com.example.currencyexchange.service.BudgetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("budgets")
public class BudgetController {
    private final BudgetService service;

    @Autowired
    public BudgetController(BudgetService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Budget> getAllBudgets() {
        return service.getAllBudgets();
    }

    @PostMapping
    public BudgetDTO addBudget(@Valid @RequestBody BudgetDTO budgetDTO) {
        return service.addBudget(budgetDTO);
    }

}
