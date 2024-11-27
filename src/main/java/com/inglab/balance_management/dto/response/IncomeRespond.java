package com.inglab.balance_management.dto.response;

import com.inglab.balance_management.model.Income;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.List;

public record IncomeRespond(
        List<Income> incomeList
) {
}
