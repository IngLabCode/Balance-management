package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.IncomeCategoryAddRequest;
import com.inglab.balance_management.dto.request.IncomeCategoryUpdateRequest;
import com.inglab.balance_management.model.IncomeCategory;
import com.inglab.balance_management.model.Incomes;
import com.inglab.balance_management.repository.ExpenseCategoryRepository;
import com.inglab.balance_management.repository.ExpensesRepository;
import com.inglab.balance_management.repository.IncomeCategoryRepository;
import com.inglab.balance_management.service.inter.IncomeCategoryInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeCategoryImpl implements IncomeCategoryInter {

    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ModelMapper modelMapper;
    private final IncomeCategoryRepository incomeCategoryRepository;

    @Override
    public void addIncome(IncomeCategoryAddRequest incomeCategoryAddRequest) {
        IncomeCategory incomeCategory=new IncomeCategory();
        modelMapper.map(incomeCategoryAddRequest,incomeCategory);
        incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    public void updateIncome(IncomeCategoryUpdateRequest incomeCategoryUpdateRequest) {
        IncomeCategory incomeCategory=new IncomeCategory();
        modelMapper.map(incomeCategoryUpdateRequest,incomeCategory);
        incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    public void deleteIncomeById(Long id) {
        incomeCategoryRepository.deleteById(id);

    }
}
