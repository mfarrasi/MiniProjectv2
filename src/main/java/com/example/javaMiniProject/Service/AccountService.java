package com.example.javaMiniProject.Service;

import com.example.javaMiniProject.Entity.Account;
import com.example.javaMiniProject.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository javaRepository;

    public Account getAccount (String param){
        Account response = new Account();
        response = javaRepository.findById(Integer.valueOf(param)).get();
        return response;
    }
}
