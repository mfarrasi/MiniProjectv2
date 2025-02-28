package com.example.miniprojectjava.controller;

import com.example.miniprojectjava.entity.ExchangeRate;
import com.example.miniprojectjava.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public ExchangeRate getExchangeRate() {
        return exchangeRateService.getExchangeRate();
    }
}
