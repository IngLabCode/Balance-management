package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.ExpenseCategoryAddRequest;
import com.inglab.balance_management.dto.request.ExpenseCategoryUpdateRequest;
import com.inglab.balance_management.service.inter.ExpenseCategoryInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expensecategory")
public class ExpenseCategoryController {
    private final ExpenseCategoryInter expenseCategoryInter;

    @PostMapping("/add")
    public void addExpenseCategory(@RequestBody ExpenseCategoryAddRequest expenseCategoryAddRequest) {
        expenseCategoryInter.addExpenseCategory(expenseCategoryAddRequest);
    }

    @PutMapping("/update")
    public void updateExpenseCategory(@RequestBody ExpenseCategoryUpdateRequest expenseCategoryUpdateRequest) {
        expenseCategoryInter.updateExpenseCategory(expenseCategoryUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpenseCategory(@PathVariable Long id) {
        expenseCategoryInter.deleteExpenseCategory(id);
    }
}
