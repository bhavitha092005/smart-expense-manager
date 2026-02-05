package com.example.expensemanager.controller;

import com.example.expensemanager.dto.BudgetRequest;
import com.example.expensemanager.entity.Budget;
import com.example.expensemanager.service.BudgetService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public Budget setBudget(@Valid @RequestBody BudgetRequest request,
                            Authentication authentication) {

        return budgetService.setBudget(
                authentication.getName(), request);
    }

    @GetMapping
    public Budget getBudget(@RequestParam int month,
                            @RequestParam int year,
                            Authentication authentication) {

        return budgetService.getBudget(
                authentication.getName(), month, year);
    }
}
