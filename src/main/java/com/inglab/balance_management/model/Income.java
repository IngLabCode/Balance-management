package com.inglab.balance_management.model;

import com.inglab.balance_management.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDate date;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private IncomeCategory category;

    // Getters və Setters
}
