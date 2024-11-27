package com.inglab.balance_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_category")
    public class ExpenseCategory {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String description;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;


}
