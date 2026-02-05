package com.example.expensemanager.controller;

import com.example.expensemanager.dto.DashboardResponse;
import com.example.expensemanager.service.DashboardService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponse getDashboard(@RequestParam int month,
                                          @RequestParam int year,
                                          Authentication authentication) {

        return dashboardService.getDashboard(
                authentication.getName(), month, year);
    }
}
