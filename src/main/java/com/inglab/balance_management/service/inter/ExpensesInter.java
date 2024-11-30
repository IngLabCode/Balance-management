package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesResponse;

import java.time.LocalDate;
import java.util.List;

public interface ExpensesInter {

    void addExpenses(ExpensesAddRequest expensesAddRequest);

    void updateExpenses(ExpensesUpdateRequest expensesUpdateRequest);

    void deleteById(Long id);

    List<ExpensesResponse> getExpensesByDate(LocalDate startDate, LocalDate endDate);

    List<ExpensesResponse> getExpenseByCategory(LocalDate startDate, LocalDate endDate, String categoryName);

}
