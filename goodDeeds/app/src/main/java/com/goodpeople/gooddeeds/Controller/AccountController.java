package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Repositories.AccountRepository;
import com.goodpeople.gooddeeds.Model.Repositories.AccountRepositoryImpl;

public class AccountController {

    private AccountRepository accountRepository = new AccountRepositoryImpl();

    public AccountController() {

    }

    public void createAccount(String name, int postalCode, String email, String password) {
        accountRepository.createAccount(name, postalCode, email, password);
    }

    public boolean validateAccountEmail(String email) {
        return accountRepository.validateAccountEmail(email);
    }

    public boolean validateLogin(String email, String password) {
        return accountRepository.validateLogin(email, password);
    }

    public void login(String email, String password) {
        accountRepository.login(email, password);
    }

    public boolean isLoggedIn() {
        return accountRepository.isLoggedIn();
    }
}
