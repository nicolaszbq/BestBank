package com.bestbank.BestBank.services.payment.impl;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.services.payment.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class DepositPaymentService implements PaymentService {
    @Override
    public void process(Transaction transaction) {

    }

    @Override
    public void reverse(Transaction transaction) {

    }
}
