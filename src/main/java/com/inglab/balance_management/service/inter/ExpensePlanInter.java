package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.ExpensePlanRequest;
import com.inglab.balance_management.dto.response.ExpensePlanResponse;
import com.inglab.balance_management.model.ExpensePlan;

public interface ExpensePlanInter {
    ExpensePlan createExpensePlan(ExpensePlan plan);
    ExpensePlanResponse evaluateExpensePlan(Long planId);

}
