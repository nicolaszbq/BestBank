package com.bestbank.BestBank.dto.request;


import java.util.Date;

public record RegisterRequestDTO(String name, String password, String email, Date birthDate) {
}
