package com.bestbank.BestBank.services;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class LimitService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void increaseLimitAmount(String targetAccount, String givenId, BigDecimal amount){
        Optional<Account> acc = accountRepository.findById(targetAccount);

        if(acc.isEmpty()){
            throw new RuntimeException("This account does not exist!");
        }else{
            if (targetAccount.equals(givenId)){
                acc.get().setLimitAmount(newLimitAmount(acc.get().getLimitAmount(), amount));
            }
        }
    }

    private BigDecimal newLimitAmount(BigDecimal oldLimit, BigDecimal newLimit){
        BigDecimal value = oldLimit.add(newLimit);
        return value;
    }
}
