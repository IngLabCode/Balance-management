package com.inglab.balance_management.dto.response;

import com.inglab.balance_management.model.IncomeCategory;

import java.util.List;
import java.util.Objects;

public record IncomeCategoryGetResponse(List<IncomeCategory> incomeCategoryList) {

    public IncomeCategoryGetResponse {
        // Ensure the list is not null and not empty
        if (incomeCategoryList == null || incomeCategoryList.isEmpty()) {
            throw new IllegalArgumentException("Income category list cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        return String.format("IncomeCategoryGetResponse{incomeCategoryList=%s}", incomeCategoryList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeCategoryGetResponse that = (IncomeCategoryGetResponse) o;
        return Objects.equals(incomeCategoryList, that.incomeCategoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incomeCategoryList);
    }

    public int getCategoryCount() {
        return incomeCategoryList.size();
    }
}
