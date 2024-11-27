package com.inglab.balance_management.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "firstname is required")
    private String firstname;
    @NotBlank(message = "firstname is required")
    private String lastname;
    @Column(unique = true)
    @NotBlank(message = "firstname is required")
    private String email;
    @NotBlank(message = "firstname is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @NotBlank(message = "firstname is required")
    private String role;

}