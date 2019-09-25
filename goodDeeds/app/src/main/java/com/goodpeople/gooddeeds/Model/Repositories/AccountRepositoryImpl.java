package com.goodpeople.gooddeeds.Model.Repositories;

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
}
