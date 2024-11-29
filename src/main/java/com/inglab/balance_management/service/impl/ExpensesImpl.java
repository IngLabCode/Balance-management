package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesRespond;
import com.inglab.balance_management.model.Expenses;
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
    public void addExpenses(ExpensesAddRequest expensesAddRequest) {
        Expenses expenses = new Expenses();
        modelMapper.map(expensesAddRequest,expenses);
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




}

