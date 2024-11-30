package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.model.Incomes;
import com.inglab.balance_management.repository.IncomeRepository;
import com.inglab.balance_management.service.inter.IncomeInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeImpl implements IncomeInter {

    private final IncomeRepository incomeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addIncome(IncomeAddRequest incomeAddRequest) {
        Incomes income = new Incomes();
        modelMapper.map(incomeAddRequest, income);
        incomeRepository.save(income);
    }

    @Override
    public void updateIncome(IncomeUpdateRequest incomeUpdateRequest) {
        Incomes income = new Incomes();
        modelMapper.map(incomeUpdateRequest, income);
        incomeRepository.save(income);
    }

    @Override
    public void deleteIncomeById(Long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public List<IncomesResponse> getIncomesByDate(LocalDate startDate, LocalDate endDate) {
       return incomeRepository.findByDateRangeAsDTO(startDate,endDate);

    }

    @Override
    public List<IncomesResponse> getIncomesByCategory(LocalDate startDate, LocalDate endDate, String categoryName) {
        return incomeRepository.findByDateRangeAndCategory(startDate,endDate,categoryName);
    }


}
