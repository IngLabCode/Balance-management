package com.inglab.balance_management.repository;

import com.inglab.balance_management.model.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory,Long> {
}
