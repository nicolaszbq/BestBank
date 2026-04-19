package com.bestbank.BestBank.services;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionHistoryService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Page<Transaction> findAllByFromAccountIdAndTimeOfTransactionBetween(
            String accountId,
            Date start,
            Date end,
            Pageable pageable
    ){
        return this.transactionRepository.findAllByFromAccountIdAndTimeOfTransactionBetween(accountId, start, end, pageable);
    }
}
