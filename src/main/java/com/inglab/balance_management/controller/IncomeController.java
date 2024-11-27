package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomeRespond;
import com.inglab.balance_management.service.inter.IncomeInter;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeInter incomService;

    @GetMapping("/getbycategory")
    public IncomeRespond etIncomesByCategoryAndDate(@RequestParam String category,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return incomService.getIncomeByCategoryAndDate(category, startDate, endDate);
    }

    @GetMapping("/getbydate")
    public IncomeRespond findByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return incomService.getIncomeByDate(startDate, endDate);

    }

    @PutMapping("/add")
    public void addIncome(@RequestBody IncomeAddRequest incomeAddRequest) {
        System.out.println(incomeAddRequest);
        incomService.addIncome(incomeAddRequest);

    }

    @PatchMapping("/update")
    public void updateIncome(@RequestBody IncomeUpdateRequest incomeUpdateRequest) {
        incomService.updateIncome(incomeUpdateRequest);
    }

    @DeleteMapping("/delete")
    public void deleteIncome(@RequestParam Long id) {
        incomService.deleteIncome(id);
    }
}
