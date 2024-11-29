package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.ExpenseCategoryAddRequest;
import com.inglab.balance_management.dto.request.ExpenseCategoryUpdateRequest;
import com.inglab.balance_management.model.ExpenseCategory;
import com.inglab.balance_management.model.IncomeCategory;
import com.inglab.balance_management.repository.ExpenseCategoryRepository;
import com.inglab.balance_management.service.inter.ExpenseCategoryInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryImpl implements ExpenseCategoryInter {
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addExpenseCategory(ExpenseCategoryAddRequest expenseCategoryAddRequest) {
        ExpenseCategory expenseCategory=new ExpenseCategory();
        modelMapper.map(expenseCategoryAddRequest,expenseCategory);
        expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    public void updateExpenseCategory(ExpenseCategoryUpdateRequest expenseCategoryUpdateRequest) {
        ExpenseCategory expenseCategory=new ExpenseCategory();
        modelMapper.map(expenseCategoryUpdateRequest,expenseCategory);
        expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    public void deleteExpenseCategory(Long id) {
        expenseCategoryRepository.deleteById(id);
    }
}
