package com.inglab.balance_management.dto.request;


import java.time.LocalDateTime;
public record IncomeAddRequest(Double amount,
                                 LocalDateTime date,
                                 String description,
                                 String paymentMethod) {


    public IncomeAddRequest {
        if (amount != null && amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}