package com.example.javaMiniProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.example.javaMiniProject.Entity.Currency;

@Data
@Entity
@Table(name = "t_exchange_rate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rate_id;

    @ManyToOne
    @JoinColumn(name = "currency_from")
    private Currency currencyFrom;

    @ManyToOne
    @JoinColumn(name = "currency_to")
    private Currency currencyTo;

    private BigDecimal rate;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
