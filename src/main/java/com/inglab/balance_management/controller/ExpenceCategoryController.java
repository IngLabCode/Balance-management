package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.request.ExpenseCategoryAddRequest;
import com.inglab.balance_management.dto.request.ExpenseCategoryUpdateRequest;
import com.inglab.balance_management.dto.response.ExpenseCategoryGetRespond;
import com.inglab.balance_management.service.inter.ExpenseCategoryInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expensecategory")
@RequiredArgsConstructor
public class ExpenceCategoryController {
    private final ExpenseCategoryInter expenseCategoryInter;

    @PutMapping("/add")
    public void add(@RequestBody ExpenseCategoryAddRequest expenseCategoryAddRequest) {
        add(expenseCategoryAddRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        delete(id);
    }

    @PatchMapping("/update")
    public void update(@PathVariable Long id, @RequestBody ExpenseCategoryUpdateRequest expenseCategoryUpdateRequest) {
        update(id, expenseCategoryUpdateRequest);
    }

    @GetMapping("/get")
    public ExpenseCategoryGetRespond get() {
        return get();
    }

}
