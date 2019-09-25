package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Repositories.AccountRepository;
import com.goodpeople.gooddeeds.Model.Repositories.AccountRepositoryImpl;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();
    private AccountRepository accountRepository = new AccountRepositoryImpl();


    public DeedController() {
    }

    public void createAccount(String name, int postalCode, String email, String password) {
        accountRepository.createAccount(name, postalCode, email, password);
    }

    public boolean validateAccountEmail(String email) {
        return accountRepository.validateAccountEmail(email);
    }
}
