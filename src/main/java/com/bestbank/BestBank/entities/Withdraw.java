package com.bestbank.BestBank.entities;

import com.bestbank.BestBank.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "withdraw_db")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String targetAccountId;
    private BigDecimal amount;
    private Date withdrawDate;
    private Status status;


    public Withdraw(String targetAccountId, BigDecimal amount, Date date, Status status) {
    }
}
