package com.bestbank.BestBank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
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
    @GeneratedValue(generator = "ulid")
    @GenericGenerator(name = "ulid", strategy = "com.bestbank.BestBank.generator.UlidGenerator")
    private String id;

    private String name;
    private String password;
    private int agency;
    private String email;
    private Date birthDate;
    private BigDecimal balanceAmount;
    private BigDecimal limitAmount;

    private BigDecimal limitSituation;

    public Account(String id, String name, int agency, String email, Date birthDate, BigDecimal balanceAmount, BigDecimal limitAmount){
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
