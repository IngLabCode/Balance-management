package com.inglab.balance_management.dto.request;

import java.util.Objects;

public record IncomeCategoryUpdateRequest(Long id, String name, String description) {

    public IncomeCategoryUpdateRequest {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if (description != null && description.length() > 500) {
            throw new IllegalArgumentException("Description should not exceed 500 characters");
        }
    }

    @Override
    public String toString() {
        return String.format("IncomeCategoryUpdateRequest{id=%d, name='%s', description='%s'}", id, name, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeCategoryUpdateRequest that = (IncomeCategoryUpdateRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
