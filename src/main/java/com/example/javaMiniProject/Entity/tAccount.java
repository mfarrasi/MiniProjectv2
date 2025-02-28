package com.example.javaMiniProject.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "t_account")
public class tAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private sUser user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private mCurrency currency;

    private BigDecimal balance;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "account_from")
    private List<tTransaction> outgoingTransactions;

    @OneToMany(mappedBy = "account_to")
    private List<tTransaction> incomingTransactions;
}
