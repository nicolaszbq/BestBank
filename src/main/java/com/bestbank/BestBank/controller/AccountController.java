package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/findall")
    public List<Account> getAccounts(){
        List<Account> accounts = accountService.findAll();
        return accounts;
    }

    @PostMapping("/save")
    public void createAccount(@RequestBody Account acc){
        accountService.save(acc);
    }

}
