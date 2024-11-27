package com.inglab.balance_management.dto.request;

public record ExpenseCategoryUpdateRequest(Long id,String name, String description) {

    public ExpenseCategoryUpdateRequest {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (description != null && description.length() > 255) {
            throw new IllegalArgumentException("Description length cannot exceed 255 characters");
        }
    }
}