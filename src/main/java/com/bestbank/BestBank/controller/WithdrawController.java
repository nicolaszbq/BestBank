package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.request.WithdrawRequestDTO;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.repository.WithdrawRepository;
import com.bestbank.BestBank.services.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/withdraw")
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/sake")
    public ResponseEntity withdraw(@RequestHeader("Authorization") String auth, @RequestBody WithdrawRequestDTO dto){
        String token = auth.replace("Bearer ", "");
        String userid = this.tokenService.validateToken(token);
        if(userid == null){
            return ResponseEntity.badRequest().build();
        }

        this.withdrawService.withdraw(dto, userid);

        return ResponseEntity.ok(dto);
    }
}
