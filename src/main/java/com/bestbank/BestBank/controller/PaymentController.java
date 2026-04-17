package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.services.payment.impl.DepositPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private DepositPaymentService paymentService = new DepositPaymentService();


    @PostMapping("/process")
    public void processPayment(@RequestBody Transaction transaction){
        paymentService.process(transaction);
    }

}
