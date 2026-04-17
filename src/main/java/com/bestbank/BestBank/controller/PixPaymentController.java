package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.services.payment.impl.PixPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix")
public class PixPaymentController {
    @Autowired
    private PixPaymentService paymentService;


    @PostMapping("/process")
    public void processPayment(@RequestBody Transaction transaction){
        paymentService.process(transaction);
    }

    @PostMapping("/reverse")
    public void reversePayment(@RequestBody Transaction transaction){
        paymentService.reverse(transaction);
    }
}
