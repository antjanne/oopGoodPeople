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

    /**
     * The addOffer method creates a new deed with information
     * from the user and a generated UUID and adds it to the list of offers.
     * Throws exception if the giving account is not found.
     *
     * @param givingAccountId the id of the account that offers the deed
     * @param subject the subject of the deed
     * @param description the description of the deed
     */
    public void addOffer(UUID givingAccountId, String subject, String description) throws Exception {
        Account givingAccount = fetchAccount(givingAccountId);
        Deed newDeed = new Deed(givingAccount, subject, description);
        deeds.add(newDeed);
    }

    private Account fetchAccount(UUID id) throws Exception {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id) {
                return accounts.get(i);
            }
        }
        throw new Exception("Invalid account id");
    }

    public List<Deed> getDeeds() {
        return deeds;
    }
}
