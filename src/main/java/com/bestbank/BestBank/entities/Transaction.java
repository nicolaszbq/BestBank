package com.bestbank.BestBank.entities;

import com.bestbank.BestBank.enums.Status;
import com.bestbank.BestBank.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transactions_db")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Long fromAccountId;

    private Long toAccountId;

    private Date timeOfTransaction;
    private BigDecimal amount;
    private Type transactionType;
    private Status transactionStatus;

    public Transaction(Long fromAccountId, Long toAccountId, BigDecimal amount, Type transactionType){
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.timeOfTransaction = new Date();
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionStatus = Status.INCOMPLETED;
    }
}
