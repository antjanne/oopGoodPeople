package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the base for the model.
 * Holds the list of existing deeds and accounts
 * and the current logged in account.
 * */

public class GoodDeeds {


    private static GoodDeeds goodDeeds;


    private List<IDeed> deeds = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private Account loggedInAccount;

    private GoodDeeds() {

        /*Account a = new Account("Anton",30597,"anton46304@gmail.com","ahah");
        Deed d = Deed.newOffer(a,"Gräsklipp","Jag hjälper gärna till att klippa gräsmattan i storgöteborg, ge mig en pling");
        Deed d2 = Deed.newOffer(a,"Hårklipp","Jag klipper gärna håret på folk! Ge mig en pling vetja!");

        accounts.add(a);
        loggedInAccount = a;
        deeds.add(d);
        deeds.add(d2);
        */
    }

    public static GoodDeeds getGoodDeeds() {
        if (goodDeeds == null) {
            goodDeeds = new GoodDeeds();
        }
        return goodDeeds;
    }

    /**
     * @return returns all Account objects that is active
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Creates new Account-object and adds it to accounts-list
     *
     * @param name       Name of person trying to create account
     * @param postalCode Postal Code of person trying to create account
     * @param email      Email of person trying to create account
     * @param password   Wanted account password
     */
    public void createAccount(String name, int postalCode, String email, String password) {
        accounts.add(new Account(name, postalCode, email, password));
    }

    /**
     * Logs in user by assigning it to variable: loggedInAccount
     *
     * @param email    email of user trying to log in
     * @param password password of user trying to log in
     */
    public void login(String email, String password) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                loggedInAccount = account;
            }
        }
    }

    /**
     * @param email    email
     * @param password password
     * @return boolean depending on whether there exists an account with those details or not
     */
    public boolean validateLogin(String email, String password) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checking so that we hold the invariant that there should be only one account per e-mail
     *
     * @param email email address
     * @return boolean depending on whether the email is already used in another account or not
     */
    public boolean isEmailUsed(String email) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a list of deeds with only the logged in account as owner of the deed.
     * Filters all deeds to only the ones the logged in account is owner of.
     * A user has to be logged in before calling this method.
     *
     * @return a list of deeds with logged in account as owner
     */

    public List<IDeed> getMyOffers() {
        List<IDeed> myDeeds = new ArrayList<>();

        for (IDeed d : deeds) {
            if (loggedInAccount == d.getGivingAccount()) {
                myDeeds.add(d);
            }
        }
        return (myDeeds);
    }

    /**
     * @return boolean depending on if the user is logged in or not
     */
    public boolean isLoggedIn() {
        return loggedInAccount != null;
    }

    /**
     * @return the logged in Account-object
     */
    public Account getAccount() {
        return this.loggedInAccount;
    }

    /**
     * Updates password for logged in account
     *
     * @param newPassword new password
     */
    public void updatePassword(String newPassword) {
        loggedInAccount.setPassword(newPassword);
    }


    /**
     * Creates a offer with the currently logged in account as giving account.
     * A user has to be logged in before calling this method.
     *
     * @param subject     The subject of the offer
     * @param description The description of the offer
     */
    public void createOffer(String subject, String description) {

        Deed newOffer = Deed.newOffer(loggedInAccount, subject, description);
        deeds.add(newOffer);
    }

    /**
     * Returns a list of all Deeds in the form of IDeed
     *
     * @return all IDeeds
     */
    public List<IDeed> getDeeds() {
        return deeds;
    }

    /**
     * sets name, email and postal code. It does not care if there actually is new values or not
     *
     * @param name       potentially new name
     * @param email      potentially new email
     * @param postalCode potentially new postal code
     */
    public void editAccount(String name, String email, int postalCode) {
        loggedInAccount.setName(name);
        loggedInAccount.setEmail(email);
        loggedInAccount.setPostalCode(postalCode);
    }
}
