package com.example.javaMiniProject.Services;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.ExchangeRate;
import com.example.javaMiniProject.Repository.CurrencyRepository;
import com.example.javaMiniProject.Repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRate> getAllExchangeRate() { return exchangeRateRepository.findAll();}
    public ExchangeRate getExchangeRateById(int id) { return exchangeRateRepository.findById(id).get();}

    @Autowired
    private CurrencyRepository currencyRepository;

    public String updateExchangeRate(Integer currencyFromId, Integer currencyToId, BigDecimal rate) {
        Optional<Currency> currencyFrom = currencyRepository.findById(currencyFromId);
        Optional<Currency> currencyTo = currencyRepository.findById(currencyToId);

        if (currencyFrom.isEmpty() || currencyTo.isEmpty()) {
            throw new RuntimeException("Currency not found!");
        }

        Optional<ExchangeRate> existingRate = exchangeRateRepository.findByCurrencyFromAndCurrencyTo(currencyFrom.get(), currencyTo.get());

        if (existingRate.isPresent()) {
            ExchangeRate exchangeRate = existingRate.get();
            exchangeRate.setRate(rate);
            exchangeRateRepository.save(exchangeRate);
            return "Exchange rate updated successfully!";
        } else {
            throw new RuntimeException("Exchange rate not found!");
        }
    }

}
