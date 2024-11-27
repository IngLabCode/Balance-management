package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.IncomeAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomeRespond;
import com.inglab.balance_management.model.Income;
import com.inglab.balance_management.repository.IncomeRepository;
import com.inglab.balance_management.service.inter.IncomeInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class IncomeImpl implements IncomeInter {

    private final IncomeRepository incomeRepository;
    private final ModelMapper modelMapper;

    @Override
    public IncomeRespond getIncomeByCategoryAndDate(String category, Date startDate, Date endDate) {
        return incomeRepository.findByCategoryAndDateBetween(category, startDate, endDate);
    }

    @Override
    public IncomeRespond getIncomeByDate(Date startDate, Date endDate) {
        return incomeRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public void addIncome(IncomeAddRequest incomeAddRequest) {
        Income income = new Income();
        modelMapper.map(incomeAddRequest, income);
        incomeRepository.save(income);
    }

    @Override
    public void updateIncome(IncomeUpdateRequest incomeUpdateRequest) {
        Income income = new Income();
        modelMapper.map(incomeUpdateRequest, income);
        incomeRepository.save(income);
    }

    @Override
    public void deleteIncome(Long id) {
        Income income = incomeRepository.findById(id).get();
        incomeRepository.delete(income);
    }


}
