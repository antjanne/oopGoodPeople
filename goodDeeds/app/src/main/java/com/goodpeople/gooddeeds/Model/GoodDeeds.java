package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import java.util.ArrayList;
import java.util.List;

public class GoodDeeds {

    private static GoodDeeds goodDeeds;

    private List<Deed> deeds = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private Account loggedinAccount;

    private GoodDeeds() {
        // TODO test account
        Account test = new Account("test", 000000, "test@test", "123");
        accounts.add(test);
        loggedinAccount = test;
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

    public void login(String email, String password) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                loggedinAccount = account;
            }
        }
    }

    public boolean validateLogin(String email, String password) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLoggedIn() {
        return loggedinAccount != null;
    }

    /**
     * Creates a offer with the currently logged in account as giving account.
     * A user has to be logged in before calling this method.
     *
     * @param subject The subject of the offer
     * @param description The description of the offer
     */
    public void createOffer(String subject, String description) {
        Account givingAccount = loggedinAccount;
        Deed newDeed = new Deed(givingAccount, subject, description);
        deeds.add(newDeed);
    }

    public List<Deed> getDeeds() {
        return deeds;
    }
}
