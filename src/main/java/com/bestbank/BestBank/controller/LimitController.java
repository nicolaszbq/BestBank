package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.services.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/limit")
public class LimitController {

    @Autowired
    private LimitService limitService;

    @PostMapping("/bufflimit")
    public void buffLimit(@RequestBody String targetAccount,@RequestBody String givenId,@RequestBody BigDecimal amount){
        this.limitService.increaseLimitAmount(targetAccount,givenId,amount);
    }
}
