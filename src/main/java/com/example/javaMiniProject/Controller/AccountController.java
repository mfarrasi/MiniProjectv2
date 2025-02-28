package com.example.javaMiniProject.Controller;

import com.example.javaMiniProject.Entity.Account;
import com.example.javaMiniProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AccountController {

    @Autowired
    AccountService javaService;

    @GetMapping("/getrekening")
    public ResponseEntity<Account> getRekening (@RequestParam String param){
        Account res = new Account();
        res = javaService.getAccount(param);
        return ResponseEntity.ok(res);
    }

//    @GetMapping("/test/")
//    public Account getAccount(){
//        return javaService.getAccount();
//    }
}
