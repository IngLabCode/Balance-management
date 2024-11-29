package com.inglab.balance_management.dto.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ExpensePlanRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalBudget;
    private double spentAmount;

}
