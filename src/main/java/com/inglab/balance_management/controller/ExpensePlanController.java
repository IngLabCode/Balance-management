package com.inglab.balance_management.controller;

import com.inglab.balance_management.dto.response.ExpensePlanResponse;
import com.inglab.balance_management.model.ExpensePlan;
import com.inglab.balance_management.service.inter.ExpensePlanInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense-plan")
@RequiredArgsConstructor
public class ExpensePlanController {

    private final ExpensePlanInter expensePlanInter;



    @PostMapping("/create")
    public ExpensePlan createPlan(@RequestBody ExpensePlan plan) {
        return expensePlanInter.createExpensePlan(plan);
    }

    @GetMapping("/evaluate/{id}")
    public ExpensePlanResponse evaluatePlan(@PathVariable Long id) {
        return expensePlanInter.evaluateExpensePlan(id);
    }
}
