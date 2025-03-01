package com.example.javaMiniProject.Services;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrency() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(int id) {
        return currencyRepository.findById(id).get();
    }

    public Currency createCurrency(Currency request) {
        Currency response = request;

        currencyRepository.save(response);
        return response;
    }
}
