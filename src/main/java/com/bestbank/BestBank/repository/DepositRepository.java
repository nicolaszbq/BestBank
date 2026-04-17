package com.bestbank.BestBank.repository;

import com.bestbank.BestBank.entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit,String> {
}
