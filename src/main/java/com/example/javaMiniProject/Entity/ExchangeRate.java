package com.example.javaMiniProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Data
@Entity
@Table(name = "t_exchange_rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rate_id;

    @ManyToOne
    @JoinColumn(name = "currency_from")
    private Currency currency_from;

    @ManyToOne
    @JoinColumn(name = "currency_to")
    private Currency currency_to;

    private BigDecimal rate;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
