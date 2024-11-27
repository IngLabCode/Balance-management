package com.inglab.balance_management.service.impl;

import com.inglab.balance_management.dto.request.IncomeCategoryAddRequest;
import com.inglab.balance_management.dto.request.IncomeUpdateRequest;
import com.inglab.balance_management.dto.response.IncomeCategoryGetResponse;
import com.inglab.balance_management.model.ExpenseCategory;
import com.inglab.balance_management.model.IncomeCategory;
import com.inglab.balance_management.repository.ExpenseCategoryRepository;
import com.inglab.balance_management.repository.IncomeCategoryRepository;
import com.inglab.balance_management.service.inter.IncomeCategoryInter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeCategoryImpl implements IncomeCategoryInter {
    private final ModelMapper modelMapper;
    private final IncomeCategoryRepository incomeCategoryRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Override
    public void addIncomeCategory(IncomeCategoryAddRequest incomeCategoryAddRequest) {
        IncomeCategory incomeCategory = new IncomeCategory();
        modelMapper.map(incomeCategoryAddRequest, incomeCategory);
        incomeCategoryRepository.save(incomeCategory);


    }

    @Override
    public void updateIncomeCategory(Long id, IncomeUpdateRequest incomeUpdateRequest) {
        Optional<IncomeCategory> incomeCategoryOptional = incomeCategoryRepository.findById(id);

        if (incomeCategoryOptional.isPresent()) {
            IncomeCategory incomeCategory = incomeCategoryOptional.get();

            modelMapper.map(incomeUpdateRequest, incomeCategory);

            incomeCategoryRepository.save(incomeCategory);
        } else {
            throw new EntityNotFoundException("Income category with id " + id + " not found");
        }
    }


    @Override
    public void deleteIncomeCategory(Long id) {
        IncomeCategory incomeCategory = incomeCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income category with id " + id + " not found"));

        incomeCategoryRepository.delete(incomeCategory);
    }


    @Override
    public IncomeCategoryGetResponse getIncomeCategory(Long id) {
        IncomeCategory incomeCategory = incomeCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No income category found for id " + id));

        return new IncomeCategoryGetResponse(List.of(incomeCategory));
    }

}
