package com.example.expensemanager.dto;

import jakarta.validation.constraints.NotNull;

public class BudgetRequest {

    @NotNull
    private Integer month;

    @NotNull
    private Integer year;

    @NotNull
    private Double amount;

    public BudgetRequest() {
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
