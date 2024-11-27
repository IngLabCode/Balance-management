package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomeRespond;

import java.util.Date;


public interface IncomeInter {
    IncomeRespond getIncomeByCategoryAndDate(String category, Date startDate, Date endDate);

    IncomeRespond getIncomeByDate(Date startDate, Date endDate);

    void addIncome(IncomeAddRequest incomeAddRequest);

    void updateIncome(IncomeUpdateRequest incomeUpdateRequest);

    void deleteIncome(Long id);


}
