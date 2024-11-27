package com.inglab.balance_management.dto.request;

import java.util.Objects;

public record IncomeCategoryAddRequest(Long id, String name, String description) {

    // Constructor to validate data during instantiation
    public IncomeCategoryAddRequest {
        // Validating 'id' can be optional depending on if it can be null or not
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }

        // Ensuring 'name' is not null or empty
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        // Validating 'description' for optional non-null requirement
        if (description != null && description.length() > 500) {
            throw new IllegalArgumentException("Description should not exceed 500 characters");
        }
    }

    // Optional: Override toString to provide meaningful output
    @Override
    public String toString() {
        return String.format("IncomeCategoryAddRequest{id=%d, name='%s', description='%s'}", id, name, description);
    }

    // Optional: hashCode and equals for better object comparison if required
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeCategoryAddRequest that = (IncomeCategoryAddRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
