package com.bestbank.BestBank.repository;

import com.bestbank.BestBank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
}
