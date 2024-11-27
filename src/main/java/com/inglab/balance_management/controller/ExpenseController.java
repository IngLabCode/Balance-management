package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesRespond;
import com.inglab.balance_management.service.impl.ExpensesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    //  Xərc kateqoriyasına və tarix aralığına görə
    @GetMapping("/getbycategory")
    public ResponseEntity<ExpensesRespond> getExpensesByCategoryAndDate(
            @RequestParam String category,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return ResponseEntity.ok(expenseService.getExpensesByCategoryAndDate(category, startDate, endDate));
    }

    //  Təkcə tarix aralığına görə
    @GetMapping("/getbydate")
    public ResponseEntity<ExpensesRespond> getExpensesByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return ResponseEntity.ok(expenseService.getExpensesByDate(startDate, endDate));
    }
}



