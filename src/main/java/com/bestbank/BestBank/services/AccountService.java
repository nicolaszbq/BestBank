package com.bestbank.BestBank.services;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public List<Account> findAll(){
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    public void save(Account a){
        accountRepository.save(a);
    }
}
