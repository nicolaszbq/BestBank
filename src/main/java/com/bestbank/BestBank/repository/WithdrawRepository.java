package com.bestbank.BestBank.repository;

import com.bestbank.BestBank.entities.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw,String> {
}
