package com.bestbank.BestBank.controller;

import com.bestbank.BestBank.dto.response.LastPixResponse;
import com.bestbank.BestBank.entities.Transaction;
import com.bestbank.BestBank.enums.Type;
import com.bestbank.BestBank.infra.security.TokenService;
import com.bestbank.BestBank.services.LastPixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/lastpix")
public class LastPixController {

    @Autowired
    private LastPixService lastPixService;

    @Autowired
    private TokenService tokenService;
    //Long fromAccountId, Type transactionType, Pageable pageable
    @GetMapping("/get")
    public ResponseEntity<List<LastPixResponse>> getLastPixes(@RequestHeader("Authorization") String rawToken){
        String token = rawToken.replace("Bearer ", "");
        String accountId = this.tokenService.validateToken(token);
        if(accountId == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        System.out.println(lastPixService.getLastPixes(accountId));
        return ResponseEntity.ok(lastPixService.getLastPixes(accountId));

    }


}
