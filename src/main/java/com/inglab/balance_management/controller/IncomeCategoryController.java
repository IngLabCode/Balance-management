package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.IncomeCategoryAddRequest;
import com.inglab.balance_management.dto.request.IncomeCategoryUpdateRequest;
import com.inglab.balance_management.service.inter.IncomeCategoryInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/incomecategory")
@RequiredArgsConstructor
public class IncomeCategoryController {

    private final IncomeCategoryInter incomeCategoryInter;

    @PostMapping("/add")
    public void addIncomeCategory(@RequestBody IncomeCategoryAddRequest incomeCategoryAddRequest){
        incomeCategoryInter.addIncome(incomeCategoryAddRequest);
    }

    @PutMapping("/update")
    public void updateIncomeCategory(@RequestBody IncomeCategoryUpdateRequest incomeCategoryUpdateRequest){
        incomeCategoryInter.updateIncome(incomeCategoryUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIncomeCategory(@PathVariable Long id){
        incomeCategoryInter.deleteIncomeById(id);
    }
}
