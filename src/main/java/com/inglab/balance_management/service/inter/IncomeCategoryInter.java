package com.inglab.balance_management.service.inter;


import com.inglab.balance_management.dto.request.IncomeCategoryAddRequest;
import com.inglab.balance_management.dto.request.IncomeCategoryUpdateRequest;

public interface IncomeCategoryInter {

    void addIncome(IncomeCategoryAddRequest incomeCategoryAddRequest);

    void updateIncome(IncomeCategoryUpdateRequest incomeCategoryUpdateRequest);

    void deleteIncomeById(Long id);
}
