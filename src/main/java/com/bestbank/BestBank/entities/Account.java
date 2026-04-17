package com.bestbank.BestBank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "accounts_db")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int agency;
    private String email;
    private Date birthDate;
    private BigDecimal balanceAmount;
    private BigDecimal limitAmount;

    private BigDecimal limitSituation;

    public Account(Long id, String name, int agency, String email, Date birthDate, BigDecimal balanceAmount, BigDecimal limitAmount){
        this.id = id;
        this.name = name;
        this.agency = agency;
        this.email = email;
        this.birthDate = new Date();
        this.balanceAmount = balanceAmount;
        this.limitAmount = limitAmount;
        this.limitSituation = new BigDecimal("0");
    }

}
