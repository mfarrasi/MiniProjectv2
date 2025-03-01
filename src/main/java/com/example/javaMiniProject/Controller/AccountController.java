package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.Account;
import com.example.javaMiniProject.Entity.Transaction;
import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getrekening")
    public ResponseEntity<List<Account>> getRekening (@RequestParam Integer param){
        List<Account> res = accountService.getAccount(param);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/createrekening")
    public Account createRekening(
            @RequestParam Integer userId,
            @RequestParam Integer currencyId,
            @RequestParam BigDecimal balance) {
        return accountService.createAccount(userId, currencyId, balance);
    }

}
