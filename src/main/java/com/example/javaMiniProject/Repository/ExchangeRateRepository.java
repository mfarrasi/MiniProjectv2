package com.example.javaMiniProject.Repository;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.ExchangeRate;
import com.example.javaMiniProject.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
    Optional<ExchangeRate> findByCurrencyFromAndCurrencyTo(Currency currencyFrom, Currency currencyTo);
}
