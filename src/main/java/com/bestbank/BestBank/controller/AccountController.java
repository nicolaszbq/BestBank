package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*
    private String name;
    private Long agency;
    private String email;
    private LocalDate brithDate;
    private BigDecimal balanceAmount;
    private BigDecimal limitAmount;
     */
    @PostMapping("/save")
    public void createAccount(){
        Account acc = new Account(null,"joao",1648,"joao@gmail.com",new Date(),new BigDecimal("2234.15"),new BigDecimal("3000"));
        accountService.save(acc);
    }

}
