package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.repository.TransactionRepository;
import com.bestbank.BestBank.services.TransactionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class TransactionHistoryController {

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping
    PagedModel<Transaction> findAllByFromAccountIdAndTimeOfTransactionBetween(
            @RequestParam(value = "accountId") Long accountId,
            @RequestParam(value = "start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date start,
            @RequestParam(value = "end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date end,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ){
        Pageable pageable = PageRequest.of(page,size);
        Page<Transaction> transactions = this.transactionHistoryService.findAllByFromAccountIdAndTimeOfTransactionBetween(
                accountId,
                start,
                end,
                pageable
        );

        return new PagedModel<>(transactions);
    }


}
