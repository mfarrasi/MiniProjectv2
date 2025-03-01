package com.example.javaMiniProject.Repository;

import com.example.javaMiniProject.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
