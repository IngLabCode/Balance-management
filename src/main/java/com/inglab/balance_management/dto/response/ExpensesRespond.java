package com.inglab.balance_management.dto.response;



import com.inglab.balance_management.model.Expenses;
import lombok.Data;

import java.util.List;
@Data
public class ExpensesRespond{
    List<Expenses> expensesList;
 
}

