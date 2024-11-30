package com.inglab.balance_management.repository;

import com.inglab.balance_management.dto.response.ExpensesResponse;
import com.inglab.balance_management.dto.response.IncomesResponse;
import com.inglab.balance_management.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    @Query(value = "SELECT i.amount AS amount, i.date AS date, i.description AS description " +
            "FROM incomes i WHERE i.date BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<ExpensesResponse> findByDateRangeAsDTO(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);



    @Query(value = "SELECT i.amount AS amount, i.date AS date, i.description AS description " +
            "FROM incomes i " +
            "JOIN income_category ic ON i.category_id = ic.id " +
            "WHERE i.date BETWEEN :startDate AND :endDate " +
            "AND ic.name = :categoryName",
            nativeQuery = true)
    List<ExpensesResponse> findByDateRangeAndCategory(@Param("startDate") LocalDate startDate,
                                                     @Param("endDate") LocalDate endDate,
                                                     @Param("categoryName") String categoryName);

}






