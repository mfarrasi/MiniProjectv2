package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    // CREATE
    @PostMapping("/createcurrency")
    public ResponseEntity<Currency> create (@RequestBody Currency request){
        Currency response = request;

        response = currencyService.createCurrency(request);

        return ResponseEntity.ok(response);
    }

    // READ
    @PostMapping("/getuser")
    public ResponseEntity<Currency> getCurrency(@RequestParam String param){
        Currency response = new Currency();

        response = currencyService.getCurrency(param);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/getuserbyname")
    public ResponseEntity<Currency> getCurrencyByName(@RequestParam String param){
        Currency response = new Currency();

        response = currencyService.getCurrencyByName(param);

        return ResponseEntity.ok(response);
    }

    // UPDATE

}
