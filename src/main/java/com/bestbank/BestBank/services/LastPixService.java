package com.bestbank.BestBank.services;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.enums.Type;
import com.bestbank.BestBank.repository.AccountRepository;
import com.bestbank.BestBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LastPixService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Page<Transaction> findAllByFromAccountIdAndTransactionTypeOrderByTimeOfTransactionDesc(
            String fromAccountId,
            Type transactionType,
            Pageable pageable
    ){

        return this.transactionRepository.findAllByFromAccountIdAndTransactionTypeOrderByTimeOfTransactionDesc(fromAccountId, transactionType, pageable);

    }
}
