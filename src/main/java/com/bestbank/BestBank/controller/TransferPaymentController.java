package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.services.payment.impl.TransferPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferPaymentController {
    @Autowired
    private TransferPaymentService paymentService = new TransferPaymentService();


    @PostMapping("/process")
    public void processPayment(@RequestBody Transaction transaction){
        paymentService.process(transaction);
    }

    @PostMapping("/reverse")
    public void reversePayment(@RequestBody Transaction transaction){
        paymentService.reverse(transaction);
    }

}
