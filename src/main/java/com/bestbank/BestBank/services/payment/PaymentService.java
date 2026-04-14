package com.bestbank.BestBank.services.payment;

import com.bestbank.BestBank.entities.Transaction;

public interface PaymentService {
    void process(Transaction transaction);
    void reverse(Transaction transaction);
}
