package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.ExpenseCategoryAddRequest;
import com.inglab.balance_management.dto.request.ExpenseCategoryUpdateRequest;

public interface ExpenseCategoryInter {
    void addExpenseCategory(ExpenseCategoryAddRequest expenseCategoryAddRequest);

    void updateExpenseCategory(ExpenseCategoryUpdateRequest expenseCategoryUpdateRequest);

    void deleteExpenseCategory(Long id);
}
