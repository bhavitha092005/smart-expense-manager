package com.example.expensemanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int month;
    private int year;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Budget() {
    }

    public Long getId() {
        return id;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Double getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

