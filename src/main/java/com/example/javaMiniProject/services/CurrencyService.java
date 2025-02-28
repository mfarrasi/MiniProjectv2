package com.example.javaMiniProject.services;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    //Create
    public Currency createCurrency(Currency request){
        Currency response = request;

        currencyRepository.save(response);

        return response;
    }

    //Read
    public Currency getCurrency(String param){
        Currency response = new Currency();

        response = currencyRepository.findById(Integer.parseInt(param)).get();

        return response;
    }

    public Currency getCurrencyByName(String param){
        Currency response = new Currency();

        response = currencyRepository.findByCurrencyName(param);

        return response;
    }

    //Update
}
