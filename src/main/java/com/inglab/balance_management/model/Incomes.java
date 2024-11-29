package com.inglab.balance_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
@Table(name = "income")
public class Incomes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDate date;
    private String description;
    private String category;
}
