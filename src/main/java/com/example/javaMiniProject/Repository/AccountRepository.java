package com.example.javaMiniProject.Repository;

import com.example.javaMiniProject.Entity.Account;
import com.example.javaMiniProject.Entity.Currency;
import com.example.javaMiniProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findByUser_UserId (Integer userId);
    Optional<Account> findByUserAndCurrency (User user, Currency currency);
}
