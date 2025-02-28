package com.example.miniprojectjava.service;

import com.example.miniprojectjava.entity.ExchangeRate;
import com.example.miniprojectjava.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate getExchangeRate() {
        return exchangeRateRepository.findAll().get(0);
    }
}
