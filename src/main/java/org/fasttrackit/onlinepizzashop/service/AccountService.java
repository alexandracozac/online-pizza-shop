package org.fasttrackit.onlinepizzashop.service;

import org.fasttrackit.onlinepizzashop.domain.Account;
import org.fasttrackit.onlinepizzashop.persistance.AccountRepository;
import org.fasttrackit.onlinepizzashop.transfer.account.SaveAccountRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private static Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;

    }

    public Account createAccount(SaveAccountRequest request){
        LOGGER.info("Creating product {} ", request);

        Account account = new Account();
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setEmail(request.getEmail());


        return accountRepository.save(account);

    }

    public Account getAccount(Long id){

        LOGGER.info("Retrieving user: {}", id);
        return accountRepository.findById(id).orElse(null);

    }


}
