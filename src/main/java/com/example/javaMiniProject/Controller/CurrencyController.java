package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getcurrency")
    public ResponseEntity<Currency> getCurrency(@RequestParam String param){
        Currency response = new Currency();

        response = currencyService.getCurrency(param);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getCurrencyByName")
    public ResponseEntity<Currency> getCurrencyByName(@RequestParam String param){
        Currency response = new Currency();

        response = currencyService.getCurrencyByName(param);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getListByCurrencyId")
    public ResponseEntity<List<Currency>> getListByCurrencyId(@RequestParam String param){

        List<Currency> response= currencyService.getListByCurrencyId(param);

        return ResponseEntity.ok(response);
    }

    // UPDATE
    @PutMapping("/updateCurrency")
    public ResponseEntity<Currency> updateCurrency(@RequestBody Currency request){
        Currency response = new Currency();

        response = currencyService.updateCurrency(request);

        return ResponseEntity.ok(response);
    }

}
