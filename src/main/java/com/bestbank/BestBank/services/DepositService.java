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
    public void deposit(DepositRequestDTO dto){
        Account acc = accountRepository.findById(dto.getDestinationAccountId()).orElseThrow(() -> new RuntimeException("This account does not exist!"));
        if(dto.getDestinationAccountId().equals(dto.getGivenId())){
            acc.setBalanceAmount(acc.getBalanceAmount().add(dto.getAmount()));
            Deposit dep = new Deposit(
                    acc.getId(),
                    dto.getAmount(),
                    new Date(),
                    Status.COMPLETED
            );
            depositRepository.save(dep);
        }else{
            throw new RuntimeException("You are not able to make this deposit!");
        }
    }
}
