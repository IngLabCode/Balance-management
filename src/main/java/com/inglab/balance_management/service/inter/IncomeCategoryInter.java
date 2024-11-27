package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.IncomeCategoryAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomeCategoryGetResponse;

public interface IncomeCategoryInter {
    void addIncomeCategory(IncomeCategoryAddRequest incomeCategoryAddRequest);

    void updateIncomeCategory(Long id,IncomeUpdateRequest incomeUpdateRequest);

    void deleteIncomeCategory(Long id);

    IncomeCategoryGetResponse getIncomeCategory(Long id);
}
