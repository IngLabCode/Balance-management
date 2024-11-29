package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;


public interface IncomeInter {

    void addIncome(IncomeAddRequest incomeAddRequest);

    void updateIncome(IncomeUpdateRequest incomeUpdateRequest);

    void deleteIncomeById(Long id);


}
