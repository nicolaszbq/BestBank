package com.bestbank.BestBank.services;

import com.bestbank.BestBank.dto.request.DepositRequestDTO;
import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.entities.Deposit;
import com.bestbank.BestBank.enums.Status;
import com.bestbank.BestBank.repository.AccountRepository;
import com.bestbank.BestBank.repository.DepositRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void deposit(DepositRequestDTO dto, String userId){
        Account acc = accountRepository.findById(userId).orElseThrow(() -> new RuntimeException("This account does not exist!"));

        acc.setBalanceAmount(acc.getBalanceAmount().add(dto.getAmount()));
        Deposit dep = new Deposit(
                acc.getId(),
                dto.getAmount(),
                new Date(),
                Status.COMPLETED
        );
        depositRepository.save(dep);
    }
}
