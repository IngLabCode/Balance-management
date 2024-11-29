package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.service.impl.ExpensesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpensesImpl expenseService;


    @PutMapping("/add")
    public void addExpenses(@RequestBody ExpensesAddRequest expensesAddRequest) {
        expenseService.addExpenses(expensesAddRequest);
    }


    @PatchMapping("/update")
    public ResponseEntity<String> updateExpenses(@RequestBody ExpensesUpdateRequest expensesUpdateRequest) {
        try {
            expenseService.updateExpenses(expensesUpdateRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Expenses updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByID(@RequestParam Long id) {
        try {
            expenseService.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Expenses deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred:" + e.getMessage());
        }
    }

}



