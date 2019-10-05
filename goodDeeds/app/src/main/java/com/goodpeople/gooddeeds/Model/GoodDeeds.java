package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GoodDeeds {

    private static GoodDeeds goodDeeds;

    private List<Deed> deeds = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private Account loggedinAccount;

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

    public List<Deed> getDeeds() {
        return deeds;
    }


    /**
     * Edits the subject and description of an already existing deed.
     * The logged in account must be the original creator of the deed.
     * @param deed The deed to be edited.
     * @param subject The subject of the deed.
     * @param description the description of the deed.
     */
    public void editOffer(Deed deed, String subject, String description) {
        if (deed.getGivingAccount() == loggedinAccount) {
            deed.setSubject(subject);
            deed.setDescription(description);
        }


    }
}
