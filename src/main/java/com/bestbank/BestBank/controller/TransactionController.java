package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.TransactionIdRequestDTO;
import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Transaction> getTransactionById(@RequestHeader("Authorization") String auth, @PathVariable String id){
        String token = auth.replace("Bearer ", "");
        String userid = this.tokenService.validateToken(token);
        if(userid == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.transactionRepository.getTransactionById(id));
    }
    @PostMapping("/getUserIdByTransactionId")
    public ResponseEntity<String> getUserIdByTransactionId(@RequestHeader("Authorization") String auth, @RequestBody TransactionIdRequestDTO transactionId){
        System.out.println("OLD Transaction id: " + transactionId.getTransactionId());
        String token = auth.replace("Bearer ", "");
        String userid = this.tokenService.validateToken(token);
        if(userid == null){
            return ResponseEntity.badRequest().build();
        }
        Transaction tr = this.transactionRepository.getTransactionById(transactionId.getTransactionId());
        System.out.println(tr);
        if(tr.getToAccountId() == null){
            return ResponseEntity.badRequest().build();
        }
        System.out.println(tr.getToAccountId());
        return ResponseEntity.ok(tr.getToAccountId());

    }
}
