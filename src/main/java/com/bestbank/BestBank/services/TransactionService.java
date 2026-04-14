package com.bestbank.BestBank.services;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction getTransactionByTransactionId(Long id){
        return transactionRepository.getTransactionById(id);
    }
}
