package com.inglab.balance_management.dto.response;


import com.inglab.balance_management.model.Incomes;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
public class IncomesResponse {
        private BigDecimal amount;
        private LocalDate date;
        private String description;

}
