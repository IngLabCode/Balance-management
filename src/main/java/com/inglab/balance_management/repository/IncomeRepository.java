package com.inglab.balance_management.repository;

import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.model.Incomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IncomeRepository extends JpaRepository<Incomes, Long> {

    @Query(value = "SELECT i.amount AS amount, i.date AS date, i.description AS description " +
            "FROM incomes i WHERE i.date BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<IncomesResponse> findByDateRangeAsDTO(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);



        @Query(value = "SELECT i.amount AS amount, i.date AS date, i.description AS description " +
                "FROM incomes i " +
                "JOIN income_category ic ON i.category_id = ic.id " +
                "WHERE i.date BETWEEN :startDate AND :endDate " +
                "AND ic.name = :categoryName",
                nativeQuery = true)
        List<IncomesResponse> findByDateRangeAndCategory(@Param("startDate") LocalDate startDate,
                                                         @Param("endDate") LocalDate endDate,
                                                         @Param("categoryName") String categoryName);

    }




