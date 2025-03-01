package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.ExchangeRate;
import com.example.javaMiniProject.Services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public List<ExchangeRate> getAllExchangeRate() { return exchangeRateService.getAllExchangeRate();}

    @GetMapping("/getExchangeRate")
    public ResponseEntity<ExchangeRate> getExchangeRateById(int id) {
        return ResponseEntity.ok(exchangeRateService.getExchangeRateById(id));
    }

    @PutMapping("/updateExchangeRate")
    public String updateExchangeRate(
            @RequestParam Integer currencyFromId,
            @RequestParam Integer currencyToId,
            @RequestParam BigDecimal rate) {
        return exchangeRateService.updateExchangeRate(currencyFromId, currencyToId, rate);
    }
}
