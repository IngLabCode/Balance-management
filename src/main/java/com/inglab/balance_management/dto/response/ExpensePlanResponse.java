package com.inglab.balance_management.dto.response;

import lombok.Data;

@Data
public class ExpensePlanResponse {
    private double difference;
    private String status;


    public ExpensePlanResponse(double abs, String status) {

    }
}
