package com.inglab.balance_management.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncomeAddRequest {

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Date must be in the present or future")
    private LocalDate date;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    @NotBlank(message = "Category is required")
    @Size(max = 100, message = "Category must not exceed 100 characters")
    private String category;
}
