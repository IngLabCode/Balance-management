package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.ExpenseCategoryAddRequest;
import com.inglab.balance_management.dto.request.ExpenseCategoryUpdateRequest;
import com.inglab.balance_management.dto.response.ExpenseCategoryGetRespond;
import com.inglab.balance_management.model.ExpenseCategory;
import com.inglab.balance_management.repository.ExpenseCategoryRepository;
import com.inglab.balance_management.service.inter.ExpenseCategoryInter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryImpl implements ExpenseCategoryInter {
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addExpenseCategory(ExpenseCategoryAddRequest expenseCategoryRequest) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        modelMapper.map(expenseCategoryRequest, expenseCategory);
        expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    public void deleteExpenseCategory(Long id) throws Exception {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id).orElseThrow(() -> new Exception("id not found"));
        expenseCategoryRepository.delete(expenseCategory);
    }

    @Override
    public void updateExpenseCategory(Long id, ExpenseCategoryUpdateRequest expenseCategoryUpdateRequest) {
        Optional<ExpenseCategory> expenseCategoryOptional = expenseCategoryRepository.findById(id);

        expenseCategoryOptional.ifPresentOrElse(expenseCategory -> {
            modelMapper.map(expenseCategoryUpdateRequest, expenseCategory);

            expenseCategoryRepository.save(expenseCategory);
        }, () -> {
            throw new EntityNotFoundException("Expense category with id " + id + " not found");
        });
    }

    @Override
    public List<ExpenseCategoryGetRespond> getExpenseCategory() {
        List<ExpenseCategory> expenseCategoryList = expenseCategoryRepository.findAll();

        List<ExpenseCategoryGetRespond> expenseCategoryGetRespondList = expenseCategoryList.stream()
                .map(expenseCategory -> modelMapper.map(expenseCategory, ExpenseCategoryGetRespond.class))
                .collect(Collectors.toList());

        return expenseCategoryGetRespondList;


    }
}
