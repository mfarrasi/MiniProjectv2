package com.example.javaMiniProject.services;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    // CREATE
    public Currency createCurrency(Currency request){

        try{
            Currency response = request;
            currencyRepository.save(response);
            response.setRc("0000");
            response.setRcDesc("Success");

            return response;
        }
        catch (Exception e){
            Currency response = request;
            response.setRc("0005");
            response.setRcDesc("General Error");

            return response;

        }
    }

    // READ
    public Currency getCurrency(String param){
        Currency response = new Currency();

        response = currencyRepository.findById(Integer.parseInt(param)).get();

        return response;
    }

    public Currency getCurrencyByName(String param) {
        Currency response = new Currency();

        response = currencyRepository.findByCurrencyName(param);

        return response;
    }

    public List<Currency> getListByCurrencyId(String param){
        List<Currency> response = new ArrayList<>();

        response = currencyRepository.findAllByCurrencyId(Integer.valueOf(param));

        return response;

    }

    // UPDATE
    public Currency updateCurrency(Currency param){
        Currency response = new Currency();

        response = currencyRepository.findById(param.getCurrencyId()).get();

        response.setCurrencyName(param.getCurrencyName());

        response = currencyRepository.save(response);

        return response;
    }
}
