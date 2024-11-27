package com.inglab.balance_management.dto.response;

import com.inglab.balance_management.model.ExpenseCategory;

import java.util.List;

public record ExpenseCategoryGetRespond(List<ExpenseCategory> expenseCategoryList) {
}
