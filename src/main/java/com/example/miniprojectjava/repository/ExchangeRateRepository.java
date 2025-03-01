package com.example.miniprojectjava.repository;

import com.example.miniprojectjava.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
}
