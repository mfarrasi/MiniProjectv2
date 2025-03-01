package com.example.miniprojectjava.controller;

import com.example.miniprojectjava.entity.Account;
import com.example.miniprojectjava.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccount() { return accountService.getAllAccount();}

    @GetMapping("/getAccount")
    public Account getAccountById(int id) { return accountService.getAccountById(id);}

    @PostMapping("/createAccount")
    public ResponseEntity<Account> create (@RequestBody Account request) {
        Account response = request;

        response = accountService.createAccount(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAccountByUserId")
    public List<Account> getAccountByUserId(int userId) { return accountService.getAccountByUserId(userId);}

    @GetMapping("/getBalanceByUserId")
    public List<Map<String, Object>> getBalanceWithCurrencyByUserId(@RequestParam int userId) {
        return accountService.getBalanceWithCurrencyByUserId(userId);
    }

}
