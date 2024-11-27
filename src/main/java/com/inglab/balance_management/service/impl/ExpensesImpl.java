package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesRespond;
import com.inglab.balance_management.model.Expense;
import com.inglab.balance_management.repository.ExpensesRepository;
import com.inglab.balance_management.service.inter.ExpensesInter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ExpensesImpl implements ExpensesInter {
    private final ExpensesRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public ExpensesRespond getExpensesByCategoryAndDate(String category, Date startDate, Date endDate) {
        return expenseRepository.findByCategoryAndDateBetween(category, startDate, endDate);
    }

    @Override
    public ExpensesRespond getExpensesByDate(Date startDate, Date endDate) {
        return expenseRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public void addExpenses(ExpensesAddRequest expensesAddRequest) {
        Expense expenses = new Expense();
        modelMapper.map(expensesAddRequest,expenses);
        expenseRepository.save(expenses);
    }

    @Override
    public void updateExpenses(ExpensesUpdateRequest expensesUpdateRequest) {
        Expense expense = new Expense();
        modelMapper.map(expensesUpdateRequest, expense);
        expenseRepository.save(expense);
    }

    @Override
    public void deleteById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense not found with id " + id));
        expenseRepository.deleteById(id);
    }




}

