package com.example.currencyexchange.controller;

import com.example.currencyexchange.domain.Budget;
import com.example.currencyexchange.dto.BudgetDTO;
import com.example.currencyexchange.service.BudgetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all budgets")
    @GetMapping
    public Iterable<Budget> getAllBudgets() {
        return service.getAllBudgets();
    }

    @Operation(summary = "Add a new budget")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Budget created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })
    @PostMapping
    public BudgetDTO addBudget(@Valid @RequestBody BudgetDTO budgetDTO) {
        return service.addBudget(budgetDTO);
    }
}
