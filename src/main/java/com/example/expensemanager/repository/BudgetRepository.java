package com.example.expensemanager.repository;

import com.example.expensemanager.entity.Budget;
import com.example.expensemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    Optional<Budget> findByUserAndMonthAndYear(User user, int month, int year);
}
