package com.inglab.balance_management.dto.request;

import java.time.LocalDateTime;

public record ExpensesUpdateRequest(Integer amount,
                                 LocalDateTime date,
                                 String description,
                                 String paymentMethod) {

    public static ExpensesUpdateRequest of(Integer amount, String description, String paymentMethod) {
        return new ExpensesUpdateRequest(amount, LocalDateTime.now(), description, paymentMethod);
    }

    public ExpensesUpdateRequest {
        if (amount != null && amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
