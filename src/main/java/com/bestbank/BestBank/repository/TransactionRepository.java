package com.bestbank.BestBank.repository;

import com.bestbank.BestBank.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Transaction getTransactionById(String id);

    Page<Transaction> findAllByFromAccountIdAndTimeOfTransactionBetween(Long fromAccountId, Date timeOfTransactionAfter, Date timeOfTransactionBefore, Pageable pageable);
}
