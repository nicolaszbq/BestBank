package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.NewPixRequestDTO;
import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.enums.Type;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.services.payment.impl.PixPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pix")
public class PixPaymentController {
    @Autowired
    private PixPaymentService paymentService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/process")
    public ResponseEntity processPayment(@RequestHeader("Authorization") String header, @RequestBody NewPixRequestDTO dto){
        String auth = header.replace("Bearer ", "");
        String id = this.tokenService.validateToken(auth);
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        Transaction transaction = new Transaction(id, dto.usercode(), dto.amount(), Type.PIX);
        this.paymentService.process(transaction);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/reverse")
    public void reversePayment(@RequestBody Transaction transaction){
        paymentService.reverse(transaction);
    }
}
