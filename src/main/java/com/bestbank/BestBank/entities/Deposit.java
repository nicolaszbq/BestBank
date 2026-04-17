package com.bestbank.BestBank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "deposits_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Long destinationAccountId;
    private BigDecimal amount;
    private Date depositDate;


    public Deposit(Long id, BigDecimal amount, Date date) {
    }
}
