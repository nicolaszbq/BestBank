package com.bestbank.BestBank.repository;

import com.bestbank.BestBank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
}
