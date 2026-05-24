package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.DepositRequestDTO;
import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.services.AccountService;
import com.bestbank.BestBank.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/make")
    public ResponseEntity deposit(
            @RequestHeader("Authorization") String auth,
            @RequestBody DepositRequestDTO dto
    ){
        String token = auth.replace("Bearer ", "");
        String userid = this.tokenService.validateToken(token);
        if(userid == null){
            return ResponseEntity.badRequest().build();
        }
        depositService.deposit(dto, userid);
        return ResponseEntity.ok(dto);
    }

}
