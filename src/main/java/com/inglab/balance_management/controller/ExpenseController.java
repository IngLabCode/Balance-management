package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.ExpensesAddRequest;
import com.inglab.balance_management.dto.request.ExpensesUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesResponse;
import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.service.impl.ExpensesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpensesImpl expensesImpl;


    @PutMapping("/add")
    public void addExpenses(@RequestBody ExpensesAddRequest expensesAddRequest) {
        expensesImpl.addExpenses(expensesAddRequest);
    }


    @PatchMapping("/update")
    public ResponseEntity<String> updateExpenses(@RequestBody ExpensesUpdateRequest expensesUpdateRequest) {
        try {
            expensesImpl.updateExpenses(expensesUpdateRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Expenses updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteByID(@RequestParam Long id) {
        try {
            expensesImpl.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Expenses deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred:" + e.getMessage());
        }
    }

    @GetMapping("/getbydate")
    public List<ExpensesResponse> getIncomesByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return expensesImpl.getExpensesByDate(startDate, endDate);
    }
    @GetMapping("/getbycatagory")
    public List<ExpensesResponse> getByCategory(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam String categoryName) {
        return expensesImpl.getExpenseByCategory(startDate,endDate,categoryName);
    }

}



