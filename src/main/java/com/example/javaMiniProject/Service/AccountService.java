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
            throw new RuntimeException("User not found");
        }
        List<Account> response = new ArrayList<>();
        response = accountRepository.findByUser_UserId(param);
        return response;
    }

    public Account createAccount (Integer userId, Integer currencyId, BigDecimal balance){
        // Find User
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();

        // Find Currency
        Optional<Currency> optionalCurrency = currencyRepository.findById(currencyId);
        if (optionalCurrency.isEmpty()) {
            throw new RuntimeException("Currency not found");
        }
        Currency currency = optionalCurrency.get();

        // Check if Account already exists with the same user id and currency id
        Optional<Account> existingAccount = accountRepository.findByUserAndCurrency(user, currency);
        if (existingAccount.isPresent()) {
            throw new RuntimeException("Account with user Id and currency Id already exists!");
        }

        // Create Account
        Account account = new Account();
        account.setUser(user);
        account.setCurrency(currency);
        account.setBalance(balance);

        return accountRepository.save(account);
    }


}
