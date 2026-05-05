package com.bestbank.BestBank.controller;

import com.auth0.jwt.JWT;
import com.bestbank.BestBank.dto.request.TokenRequest;
import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/findall")
    public List<Account> getAccounts(){
        List<Account> accounts = accountService.findAll();
        return accounts;
    }

    @GetMapping("/getAmountByToken")
    public ResponseEntity<BigDecimal> getAmountByToken(@RequestHeader("Authorization") String dto){
        String token = dto.replace("Bearer ", "");
        String id = tokenService.validateToken(token);

        System.out.println("Given token: "+ dto);
        System.out.println("CONVERTED ID: "+ id);
        if(id != null){
            return ResponseEntity.ok(accountService.findById(id).get().getBalanceAmount());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

}
