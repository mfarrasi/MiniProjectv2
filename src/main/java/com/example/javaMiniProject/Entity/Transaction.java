package com.example.javaMiniProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id;

    @ManyToOne
    @JoinColumn(name = "account_from")
    private Account account_from;

    @ManyToOne
    @JoinColumn(name = "account_to")
    private Account account_to;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private ExchangeRate rate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
