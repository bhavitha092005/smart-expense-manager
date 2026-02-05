package com.example.expensemanager.controller;

import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.entity.User;
import com.example.expensemanager.repository.ExpenseRepository;
import com.example.expensemanager.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;

    public AdminController(UserRepository userRepository,
                           ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
