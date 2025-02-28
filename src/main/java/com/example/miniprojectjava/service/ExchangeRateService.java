package com.example.miniprojectjava.service;

import com.example.miniprojectjava.entity.ExchangeRate;
import com.example.miniprojectjava.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRate> getAllExchangeRate() { return exchangeRateRepository.findAll();}
    public ExchangeRate getExchangeRateById(int id) { return exchangeRateRepository.findById(id).get();}

}
