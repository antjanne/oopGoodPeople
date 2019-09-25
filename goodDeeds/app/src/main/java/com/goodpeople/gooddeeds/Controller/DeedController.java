package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.GoodDeeds;

public class DeedController {
    private final GoodDeeds goodDeeds;

    public DeedController() {
        this.goodDeeds = GoodDeeds.getGoodDeeds();
    }

    public void createAccount(String name, int postalCode, String email, String password) {
        goodDeeds.createAccount(name, postalCode, email, password);
    }

    public boolean validateAccountEmail(String email) {
        return goodDeeds.validateAccountEmail(email);
    }
}
