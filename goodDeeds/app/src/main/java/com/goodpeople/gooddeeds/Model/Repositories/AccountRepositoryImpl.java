package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

public class AccountRepositoryImpl implements AccountRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    @Override
    public void createAccount(String name, int postalCode, String email, String password) {
        goodDeeds.createAccount(name, postalCode, email, password);
    }

    @Override
    public boolean validateAccountEmail(String email) {
        return goodDeeds.validateAccountEmail(email);
    }

    @Override
    public void login(String email, String password) {
        goodDeeds.login(email, password);
    }

    @Override
    public boolean validateLogin(String email, String password) {
        return goodDeeds.validateLogin(email, password);
    }

    @Override
    public boolean isLoggedIn() {
        return goodDeeds.isLoggedIn();
    }

    @Override
    public Account getAccount() {
        return goodDeeds.getAccount();
    }


}
