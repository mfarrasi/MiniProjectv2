package com.example.javaMiniProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
@Table(name = "m_currency")
public class mCurrency {
    @Id
    @Column(name = "currency_id")
    private Integer currencyId;

    @Column(name = "currency_name")
    private String currencyName;

//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
}
