package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.WithdrawRequestDTO;
import com.bestbank.BestBank.repository.WithdrawRepository;
import com.bestbank.BestBank.services.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/withdraw")
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;
    @PostMapping("/sake")
    public void withdraw(@RequestBody WithdrawRequestDTO dto){
        this.withdrawService.withdraw(dto);
    }
}
