package com.bestbank.BestBank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawRequestDTO {
    private Long targetAccountId;
    private BigDecimal amount;
    private Long givenId;
}
