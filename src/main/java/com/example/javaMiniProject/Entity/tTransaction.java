package com.example.javaMiniProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Data
@Table(name = "t_transaction")
public class tTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaction_id;

    @ManyToOne
    @JoinColumn(name = "account_from")
    private tAccount account_from;

    @ManyToOne
    @JoinColumn(name = "account_to")
    private tAccount account_to;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private mCurrency currency;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private tExchangeRate rate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private mTransactionType type;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private mStatus status;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
