package com.inglab.balance_management.dto.request;

import lombok.Data;

@Data
public class IncomeCategoryUpdateRequest {
    private String name;
    private String description;
}
