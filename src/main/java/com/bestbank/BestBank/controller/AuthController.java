package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.LoginRequestDTO;
import com.bestbank.BestBank.dto.request.RegisterRequestDTO;
import com.bestbank.BestBank.dto.response.ResponseDTO;
import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO dto){
        Account acc = this.accountRepository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("User not found!"));
        if(passwordEncoder.matches(dto.password(),acc.getPassword())){
            String token = this.tokenService.generateToken(acc);
            return ResponseEntity.ok(new ResponseDTO(acc.getName(),token));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO dto){
        Optional<Account> acc = this.accountRepository.findByEmail(dto.email());
        if(acc.isEmpty()){
            Account account = new Account();
            account.setPassword(passwordEncoder.encode(dto.password()));
            account.setEmail(dto.email());
            account.setName(dto.name());
            account.setBirthDate(dto.birthDate());
            account.setBalanceAmount(new BigDecimal("0"));
            account.setLimitAmount(new BigDecimal("0"));
            account.setAgency(1593);
            this.accountRepository.save(account);
            String token = this.tokenService.generateToken(account);
            return ResponseEntity.ok(new ResponseDTO(account.getName(),token));

        }else{
            return ResponseEntity.badRequest().build();
        }

    }
}
