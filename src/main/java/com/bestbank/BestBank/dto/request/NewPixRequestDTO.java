package com.bestbank.BestBank.dto.request;

import java.math.BigDecimal;

public record NewPixRequestDTO(
        BigDecimal amount,
        String usercode
        ) {
}
