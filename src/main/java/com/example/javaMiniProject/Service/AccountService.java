package com.example.javaMiniProject.Service;

import com.example.javaMiniProject.Entity.Account;
import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Repository.AccountRepository;
import com.example.javaMiniProject.Repository.CurrencyRepository;
import com.example.javaMiniProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Account> getAccount (Integer param){
        Optional<User> optionalUser = userRepository.findById(param);
        if (optionalUser.isEmpty()) {
            List<Account> responseList = new ArrayList<>();
            Account response = new Account();
            response.setRc("0005");
            response.setRcDesc("User not found");
            responseList.add(response);
            return responseList;
        }
        List<Account> responseList = new ArrayList<>();
        responseList = accountRepository.findByUser_UserId(param);
        Account response = new Account();
        response.setRc("0000");
        response.setRcDesc("Success");
        responseList.add(response);
        return responseList;
    }

    public Account createAccount (Integer userId, Integer currencyId, BigDecimal balance){
        // Find User
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            Account response = new Account();
            response.setRc("0005");
            response.setRcDesc("User not found");
            return response;
        }
        User user = optionalUser.get();

        // Find Currency
        Optional<Currency> optionalCurrency = currencyRepository.findById(currencyId);
        if (optionalCurrency.isEmpty()) {
            Account response = new Account();
            response.setRc("0005");
            response.setRcDesc("Currency not found");
            return response;
        }
        Currency currency = optionalCurrency.get();

        // Check if Account already exists with the same user id and currency id
        Optional<Account> existingAccount = accountRepository.findByUserAndCurrency(user, currency);
        if (existingAccount.isPresent()) {
            Account response = new Account();
            response.setRc("0005");
            response.setRcDesc("Account with user Id and currency Id already exists!");
            return response;
        }

        // Create Account
        Account account = new Account();
        account.setUser(user);
        account.setCurrency(currency);
        account.setBalance(balance);
        account.setRc("0000");
        account.setRcDesc("Success");
        accountRepository.save(account);
        return account;
    }


}
