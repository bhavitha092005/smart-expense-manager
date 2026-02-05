package com.example.expensemanager.service;

import com.example.expensemanager.dto.BudgetRequest;
import com.example.expensemanager.entity.Budget;
import com.example.expensemanager.entity.User;
import com.example.expensemanager.repository.BudgetRepository;
import com.example.expensemanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public BudgetService(BudgetRepository budgetRepository,
                         UserRepository userRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }

    public Budget setBudget(String username, BudgetRequest request) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Budget budget = budgetRepository
                .findByUserAndMonthAndYear(
                        user, request.getMonth(), request.getYear())
                .orElse(new Budget());

        budget.setUser(user);
        budget.setMonth(request.getMonth());
        budget.setYear(request.getYear());
        budget.setAmount(request.getAmount());

        return budgetRepository.save(budget);
    }

    public Budget getBudget(String username, int month, int year) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return budgetRepository
                .findByUserAndMonthAndYear(user, month, year)
                .orElse(null);
    }
}
