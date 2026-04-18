package com.bestbank.BestBank.services.payment.impl;

import com.bestbank.BestBank.entities.Account;
import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.enums.Status;
import com.bestbank.BestBank.enums.Type;
import com.bestbank.BestBank.repository.AccountRepository;
import com.bestbank.BestBank.repository.TransactionRepository;
import com.bestbank.BestBank.services.payment.PaymentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TransferPaymentService implements PaymentService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void process(Transaction transaction) {
        Long fromId = transaction.getFromAccountId();
        Long toId = transaction.getToAccountId();
        Account from = accountRepository.findById(fromId).orElseThrow(() -> new RuntimeException("conta nao encontrada"));
        Account to = accountRepository.findById(toId).orElseThrow(() -> new RuntimeException("conta nao encontrada"));

        BigDecimal amount = transaction.getAmount();
        if(from.getBalanceAmount().compareTo(transaction.getAmount()) < 0){
            throw new RuntimeException("You cannot make this transfer, due to your balance amount");
        }else{
            if (isLimitSituationCapableToMakeTransfer(from, transaction)){
                addMoney(to, transaction.getAmount());
                takeMoney(from, transaction.getAmount());
                BigDecimal newSit = from.getLimitSituation().add(amount);
                from.setLimitSituation(newSit);
                transaction.setTransactionType(Type.TRANSFER);
                transaction.setTransactionStatus(Status.COMPLETED);
                transaction.setTimeOfTransaction(new Date());
                transactionRepository.save(transaction);
            }else{
                throw new RuntimeException("You cannot make this transfer, due to your limit amount");
            }
        }
    }

    @Override
    @Transactional
    public void reverse(Transaction transaction) {
        Long fromId = transaction.getFromAccountId();
        Long toId = transaction.getToAccountId();
        Account from = accountRepository.findById(fromId).orElseThrow(() -> new RuntimeException("conta nao encontrada"));
        Account to = accountRepository.findById(toId).orElseThrow(() -> new RuntimeException("conta nao encontrada"));

        BigDecimal amount = transaction.getAmount();
        if(transaction.getTransactionStatus() == Status.REVERSED || transaction.getTransactionStatus() == Status.CANCELED ){
            throw new RuntimeException("This transaction, was already reversed!");
        }else{
            addMoney(from, transaction.getAmount());
            takeMoney(to, transaction.getAmount());
            from.setLimitSituation(from.getLimitSituation().subtract(amount));
            transactionRepository.deleteById(transaction.getId());
            transaction.setTransactionStatus(Status.REVERSED);
        }
    }

    private boolean isLimitSituationCapableToMakeTransfer(Account acc, Transaction transaction){
        BigDecimal value = acc.getLimitSituation().add(transaction.getAmount());
        if(value.compareTo(acc.getLimitAmount()) > 0){
            return false;
        }
        return true;
    }

    private void addMoney(Account receiver, BigDecimal amount){
        BigDecimal oldAmount = receiver.getBalanceAmount();
        receiver.setBalanceAmount(oldAmount.add(amount));
    }
    private void takeMoney(Account deliver, BigDecimal amount){
        BigDecimal oldAmount = deliver.getBalanceAmount();
        deliver.setBalanceAmount(oldAmount.subtract(amount));
    }

}
