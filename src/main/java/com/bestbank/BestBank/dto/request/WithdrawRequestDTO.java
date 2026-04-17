package com.bestbank.BestBank.dto.request;

import com.bestbank.BestBank.enums.Status;
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
public class WithdrawRequestDTO {
    private Long targetAccountId;
    private BigDecimal amount;
    private Long givenId;
}
