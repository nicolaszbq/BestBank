package com.bestbank.BestBank.dto.request;

import com.bestbank.BestBank.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositRequestDTO {
    private String destinationAccountId;
    private BigDecimal amount;
    private String givenId;
}
