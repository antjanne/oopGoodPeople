package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;

import java.util.ArrayList;
import java.util.List;

public final class GoodDeeds {

    private static GoodDeeds goodDeeds;

    private List<Deed> offers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    private GoodDeeds() {
    }

    public static GoodDeeds getGoodDeeds() {
        if (goodDeeds == null) {
            goodDeeds = new GoodDeeds();
        }
        return goodDeeds;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void createAccount(String name, int postalCode, String email, String password) {
        accounts.add(new Account(name, postalCode, email, password));
    }

    public boolean validateAccountEmail(String email) {
        for (Account account :
                accounts) {
            if (account.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

}
