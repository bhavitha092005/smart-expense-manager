package com.example.expensemanager.controller;

import com.example.expensemanager.dto.ExpenseRequest;
import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@Valid @RequestBody ExpenseRequest request,
                              Authentication authentication) {

        return expenseService.addExpense(
                authentication.getName(), request);
    }

    @GetMapping
    public List<Expense> getUserExpenses(Authentication authentication) {

        return expenseService.getUserExpenses(authentication.getName());
    }
}
