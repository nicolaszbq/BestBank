package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.DepositRequestDTO;
import com.bestbank.BestBank.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;
    @PostMapping("/make")
    public void deposit(@RequestBody DepositRequestDTO dto){
        depositService.deposit(dto);
    }

}
