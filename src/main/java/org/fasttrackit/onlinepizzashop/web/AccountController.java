package org.fasttrackit.onlinepizzashop.web;


import org.fasttrackit.onlinepizzashop.domain.Account;
import org.fasttrackit.onlinepizzashop.service.AccountService;
import org.fasttrackit.onlinepizzashop.transfer.account.SaveAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {


    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Valid SaveAccountRequest request) throws ValidationException {
        Account account = accountService.createAccount(request);
        return new ResponseEntity<>(account, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Account>getAccount(@PathVariable ("id") long id ){
        Account account = accountService.getAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);

    }


}
