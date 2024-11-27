package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.ExpenseCategoryAddRequest;
import com.inglab.balance_management.dto.request.ExpenseCategoryUpdateRequest;
import com.inglab.balance_management.dto.response.ExpenseCategoryGetRespond;

import java.util.List;

public interface ExpenseCategoryInter {
    void addExpenseCategory(ExpenseCategoryAddRequest expenseCategoryRequest);
    void deleteExpenseCategory(Long id) throws Exception;
    void updateExpenseCategory(Long id, ExpenseCategoryUpdateRequest expenseCategoryUpdateRequest) throws Exception;
    List<ExpenseCategoryGetRespond> getExpenseCategory();


}
