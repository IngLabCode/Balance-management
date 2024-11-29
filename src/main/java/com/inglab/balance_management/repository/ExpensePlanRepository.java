package com.inglab.balance_management.repository;

import com.inglab.balance_management.model.ExpensePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensePlanRepository extends JpaRepository<ExpensePlan, Long> {
}
