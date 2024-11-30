package com.inglab.balance_management.dto.response;



import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class ExpensesResponse {

    private BigDecimal amount;
    private LocalDate date;
    private String description;
 
}

