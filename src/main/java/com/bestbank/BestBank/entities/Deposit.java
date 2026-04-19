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
@Table(name = "deposits_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String destinationAccountId;
    private BigDecimal amount;
    private Date depositDate;
    private Status status;

    public Deposit(String id, BigDecimal amount, Date date, Status status) {
    }
}
