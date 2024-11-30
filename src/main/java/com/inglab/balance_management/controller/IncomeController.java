package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.service.impl.IncomeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeImpl incomeImpl;


    @PostMapping("/add")
    public void addIncome(@RequestBody IncomeAddRequest incomeAddRequest) {
        System.out.println(incomeAddRequest);
        incomeImpl.addIncome(incomeAddRequest);

    }

    @PutMapping("/update")
    public void updateIncome(@RequestBody IncomeUpdateRequest incomeUpdateRequest) {
        incomeImpl.updateIncome(incomeUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeImpl.deleteIncomeById(id);
    }

    @GetMapping("/getbydate")
    public List<IncomesResponse> getIncomesByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return incomeImpl.getIncomesByDate(startDate, endDate);
    }

    @GetMapping("/getbycatagory")
    public List<IncomesResponse> getByCategory(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate,@RequestParam String categoryName) {
        return incomeImpl.getIncomesByDate(startDate, endDate);
    }
}
