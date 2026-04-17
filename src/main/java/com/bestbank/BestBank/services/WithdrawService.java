package com.bestbank.BestBank.services;

import com.bestbank.BestBank.dto.request.WithdrawRequestDTO;
import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.entities.Withdraw;
import com.bestbank.BestBank.enums.Status;
import com.bestbank.BestBank.repository.AccountRepository;
import com.bestbank.BestBank.repository.WithdrawRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WithdrawService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WithdrawRepository withdrawRepository;


    @Transactional
    public void withdraw(WithdrawRequestDTO dto){
        Account acc = accountRepository.findById(dto.getTargetAccountId()).orElseThrow(() -> new RuntimeException("This account does not exist!"));
        if (acc.getId().equals(dto.getGivenId())){
            acc.setBalanceAmount(acc.getBalanceAmount().subtract(dto.getAmount()));
            Withdraw wit = new Withdraw(
                    dto.getTargetAccountId(),
                    dto.getAmount(),
                    new Date(),
                    Status.COMPLETED
            );
            withdrawRepository.save(wit);
        }else{
            throw new RuntimeException("Your Id doesnt match with target's account id!");
        }
    }
}
