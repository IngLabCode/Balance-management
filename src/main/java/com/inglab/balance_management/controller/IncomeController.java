package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.service.impl.IncomeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
