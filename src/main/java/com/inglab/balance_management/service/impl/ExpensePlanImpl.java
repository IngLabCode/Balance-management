package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.response.ExpensePlanResponse;
import com.inglab.balance_management.model.ExpensePlan;
import com.inglab.balance_management.repository.ExpensePlanRepository;
import com.inglab.balance_management.service.inter.ExpensePlanInter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExpensePlanImpl implements ExpensePlanInter {
    private final ExpensePlanRepository repository;


    @Override
    public ExpensePlan createExpensePlan(ExpensePlan plan) {
        return repository.save(plan);
    }

    @Override
    public ExpensePlanResponse evaluateExpensePlan(Long planId) {
        Optional<ExpensePlan> optionalPlan = repository.findById(planId);
        if (optionalPlan.isEmpty()) {
            throw new IllegalArgumentException("Plan tapılmadı");
        }

        ExpensePlan plan = optionalPlan.get();
        LocalDate startDate = plan.getStartDate();
        LocalDate endDate = plan.getEndDate();
        double totalBudget = plan.getTotalBudget();
        double spentAmount = plan.getSpentAmount();

        long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        long elapsedDays = ChronoUnit.DAYS.between(startDate, LocalDate.now());

        if (elapsedDays > totalDays) elapsedDays = totalDays;

        double expectedSpent = (elapsedDays * totalBudget) / totalDays;
        double difference = spentAmount - expectedSpent;

        String status;
        if (difference > 0) {
            status = "Gedişat pisdir. Çox xərclənib.";
        } else {
            status = "Gedişat yaxşıdır.";
        }

        return new ExpensePlanResponse(Math.abs(difference), status);
    }
}
