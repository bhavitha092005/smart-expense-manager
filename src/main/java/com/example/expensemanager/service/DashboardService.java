package com.example.expensemanager.service;

import com.example.expensemanager.dto.DashboardResponse;
import com.example.expensemanager.entity.Budget;
import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.entity.User;
import com.example.expensemanager.repository.BudgetRepository;
import com.example.expensemanager.repository.ExpenseRepository;
import com.example.expensemanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DashboardService {

    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public DashboardService(ExpenseRepository expenseRepository,
                            BudgetRepository budgetRepository,
                            UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }

    public DashboardResponse getDashboard(String username, int month, int year) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<Expense> expenses =
                expenseRepository.findByUserAndDateBetween(user, start, end);

        double totalExpenses = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        Budget budget = budgetRepository
                .findByUserAndMonthAndYear(user, month, year)
                .orElse(null);

        double budgetAmount = budget != null ? budget.getAmount() : 0;
        double remaining = budgetAmount - totalExpenses;

        Map<String, Double> categoryMap = new HashMap<>();

        for (Expense expense : expenses) {
            categoryMap.put(
                    expense.getCategory(),
                    categoryMap.getOrDefault(expense.getCategory(), 0.0)
                            + expense.getAmount()
            );
        }

        return new DashboardResponse(
                totalExpenses,
                budgetAmount,
                remaining,
                categoryMap
        );
    }
}
