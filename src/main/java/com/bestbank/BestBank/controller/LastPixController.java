package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.enums.Type;
import com.bestbank.BestBank.services.LastPixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lastpix")
public class LastPixController {

    @Autowired
    private LastPixService lastPixService;

    //Long fromAccountId, Type transactionType, Pageable pageable
    @GetMapping
    public PagedModel<Transaction> findAllByFromAccountIdAndTransactionType(
        @RequestParam(value = "fromAccountId") Long fromAccountId
        //@RequestParam(value = "transactionType")Type transactionType,
        //@RequestParam(value = "page", defaultValue = "0") int page,
        //@RequestParam(value = "size", defaultValue = "5") int size,
        ){
        Pageable pageable = PageRequest.of(0,5);
        Page<Transaction> pixes = this.lastPixService.findAllByFromAccountIdAndTransactionTypeOrderByTimeOfTransactionDesc(
                fromAccountId,
                Type.PIX,
                pageable);

        return new PagedModel<>(pixes);


    }
}
