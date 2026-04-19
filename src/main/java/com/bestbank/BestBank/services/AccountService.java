package com.bestbank.BestBank.services;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public List<Account> findAll(){
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    public void save(Account a){
        Account b = new Account(null,a.getName(), a.getPassword(),a.getAgency(),a.getEmail(),new Date(), a.getBalanceAmount(),a.getLimitAmount(),new BigDecimal("0"));
        accountRepository.save(b);
    }
}
