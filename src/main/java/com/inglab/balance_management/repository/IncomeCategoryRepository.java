package com.inglab.balance_management.repository;

import com.inglab.balance_management.model.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory,Long> {
}
