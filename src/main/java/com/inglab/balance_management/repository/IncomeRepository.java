package com.inglab.balance_management.repository;

import com.inglab.balance_management.model.Incomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncomeRepository extends JpaRepository<Incomes, Long> {

}
