package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesResponse;
import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.model.ExpenseCategory;
import com.inglab.balance_management.model.Expenses;
import com.inglab.balance_management.model.User;
import com.inglab.balance_management.repository.ExpensesRepository;
import com.inglab.balance_management.service.inter.ExpensesInter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesImpl implements ExpensesInter {
    private final ExpensesRepository expenseRepository;
    private final ModelMapper modelMapper;


    @Override
    public void addExpenses(ExpensesAddRequest expensesAddRequest) {
        Expenses expenses = new Expenses();
        expenses.setDate(expensesAddRequest.getDate());
        expenses.setAmount(BigDecimal.valueOf(expensesAddRequest.getAmount()));
        expenses.setDescription(expensesAddRequest.getDescription());
//        ExpenseCategory expenseCategory=new ExpenseCategory();
//        expenseCategory.setId(expenses.getId());
//        expenses.setExpenseCategory(expenseCategory);
//        User user=new User();
//        user.setId(expenses.getId());
//        expenses.setUser(user);
        expenseRepository.save(expenses);
    }

    @Override
    public void updateExpenses(ExpensesUpdateRequest expensesUpdateRequest) {
        Expenses expense = new Expenses();
        modelMapper.map(expensesUpdateRequest, expense);
        expenseRepository.save(expense);
    }

    @Override
    public void deleteById(Long id) {
        Expenses expense = expenseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense not found with id " + id));
        expenseRepository.deleteById(id);
    }

    @Override
    public List<ExpensesResponse> getExpensesByDate(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByDateRangeAsDTO(startDate, endDate);


    }
    @Override
    public List<ExpensesResponse> getExpenseByCategory(LocalDate startDate, LocalDate endDate, String categoryName) {
        return expenseRepository.findByDateRangeAndCategory(startDate,endDate,categoryName);
    }
}

