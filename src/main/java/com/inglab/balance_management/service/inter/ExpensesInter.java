package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesRespond;

import java.util.Date;

public interface ExpensesInter {
    ExpensesRespond getExpensesByCategoryAndDate(String category, Date startDate, Date endDate);

    ExpensesRespond getExpensesByDate(Date startDate, Date endDate);

    void addExpenses(ExpensesAddRequest expensesAddRequest);
    void updateExpenses(ExpensesUpdateRequest expensesUpdateRequest);
    void deleteById(Long id);



}
