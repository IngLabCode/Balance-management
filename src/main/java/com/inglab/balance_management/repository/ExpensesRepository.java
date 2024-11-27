package com.inglab.balance_management.repository;

import com.inglab.balance_management.dto.response.ExpensesRespond;
import com.inglab.balance_management.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ExpensesRepository extends JpaRepository<Expense, Long> {




    @Query("SELECT e FROM Expense e WHERE e.category = :category AND e.date BETWEEN :startDate AND :endDate")
    ExpensesRespond findByCategoryAndDateBetween(@Param("category") String category,
                                                 @Param("startDate") Date startDate,
                                                 @Param("endDate") Date endDate);

    @Query("SELECT e FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    ExpensesRespond findByDateBetween(@Param("startDate") Date startDate,
                                      @Param("endDate") Date endDate);
}

