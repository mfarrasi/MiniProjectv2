package com.example.javaMiniProject.Repository;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
