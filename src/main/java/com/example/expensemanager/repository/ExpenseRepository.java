package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Expense;
import com.example.expensemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(User user);

    List<Expense> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
}
