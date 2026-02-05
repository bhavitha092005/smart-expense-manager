package com.example.expensemanager.dto;

import java.util.Map;

public class DashboardResponse {

    private Double totalExpenses;
    private Double budget;
    private Double remaining;
    private Map<String, Double> categoryWiseExpenses;

    public DashboardResponse() {
    }

    public DashboardResponse(Double totalExpenses, Double budget, Double remaining,
                             Map<String, Double> categoryWiseExpenses) {
        this.totalExpenses = totalExpenses;
        this.budget = budget;
        this.remaining = remaining;
        this.categoryWiseExpenses = categoryWiseExpenses;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public Double getBudget() {
        return budget;
    }

    public Double getRemaining() {
        return remaining;
    }

    public Map<String, Double> getCategoryWiseExpenses() {
        return categoryWiseExpenses;
    }
}
