package com.inglab.balance_management.repository;

import com.inglab.balance_management.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {




}

