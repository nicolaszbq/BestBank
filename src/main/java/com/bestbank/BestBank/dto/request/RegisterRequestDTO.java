package com.bestbank.BestBank.dto.request;


import java.time.LocalDate;
import java.util.Date;

public record RegisterRequestDTO(String name, String password, String email, LocalDate birthDate) {
}
