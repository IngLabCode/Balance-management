package com.inglab.balance_management.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeUpdateRequest {

    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @FutureOrPresent(message = "Date must be in the present or future")
    private LocalDate date;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    @Size(max = 100, message = "Category must not exceed 100 characters")
    private String category;
}
