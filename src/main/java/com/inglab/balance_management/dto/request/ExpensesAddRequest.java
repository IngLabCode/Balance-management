package com.inglab.balance_management.dto.request;


import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ExpensesAddRequest {

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    @NotNull(message = "Date cannot be null")
    @FutureOrPresent(message = "Date must be in the present or future")
    private LocalDate date;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;
}
