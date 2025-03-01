package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAllCurrency() {
        return currencyService.getAllCurrency();
    }

    @GetMapping("/getCurrency")
    public ResponseEntity<Currency> getCurrencyateById(int id) {
        return ResponseEntity.ok(currencyService.getCurrencyById(id));
    }

    @PostMapping("/createCurrency")
    public ResponseEntity<Currency> create (@RequestBody Currency request) {
        Currency response = request;

        response = currencyService.createCurrency(request);

        return ResponseEntity.ok(response);
    }
}
