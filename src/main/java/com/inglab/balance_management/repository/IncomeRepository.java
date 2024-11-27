package com.inglab.balance_management.repository;

import com.inglab.balance_management.dto.response.IncomeRespond;
import com.inglab.balance_management.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT new com.inglab.balance_management.dto.response.IncomeRespond(I.category, I.date) " +
            "FROM Income I WHERE I.category = :category AND I.date BETWEEN :startDate AND :endDate")
    IncomeRespond findByCategoryAndDateBetween(@Param("category") String category,
                                               @Param("startDate") Date startDate,
                                               @Param("endDate") Date endDate);

    @Query("SELECT new com.inglab.balance_management.dto.response.IncomeRespond(I.date) " +
            "FROM Income I WHERE I.date BETWEEN :startDate AND :endDate")
    IncomeRespond findByDateBetween(@Param("startDate") Date startDate,
                                    @Param("endDate") Date endDate);
}
