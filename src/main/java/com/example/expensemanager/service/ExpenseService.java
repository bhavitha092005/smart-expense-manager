package com.example.expensemanager.service;

import com.example.expensemanager.dto.ExpenseRequest;
import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.entity.User;
import com.example.expensemanager.repository.ExpenseRepository;
import com.example.expensemanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Expense addExpense(String username, ExpenseRequest request) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense();
        expense.setCategory(request.getCategory());
        expense.setAmount(request.getAmount());
        expense.setDate(request.getDate());
        expense.setDescription(request.getDescription());
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getUserExpenses(String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return expenseRepository.findByUser(user);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
