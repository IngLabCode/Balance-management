package com.inglab.balance_management.service.inter;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.ExpensesResponse;
import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.model.Incomes;

import java.time.LocalDate;
import java.util.List;


public interface IncomeInter {

    void addIncome(IncomeAddRequest incomeAddRequest);

    void updateIncome(IncomeUpdateRequest incomeUpdateRequest);

    void deleteIncomeById(Long id);

    List<IncomesResponse> getIncomesByDate(LocalDate startDate, LocalDate endDate);

    List<IncomesResponse> getIncomesByCategory(LocalDate startDate, LocalDate endDate, String categoryName);

}
