package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.Entities.IAccount;
import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.ArrayList;
import java.util.List;


public class GoodDeeds {

    private static GoodDeeds goodDeeds;

    private List<IDeed> deeds = new ArrayList<>();
    private List<IAccount> accounts = new ArrayList<>();
    private IAccount loggedInAccount;

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
    public List<IAccount> getAccounts() {
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
        for (IAccount account : accounts) {
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
        for (IAccount account : accounts) {
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
        for (IAccount account : accounts) {
            if (account.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
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
    public IAccount getAccount() {
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
     * Returns a list of all existing deeds.
     *
     * @return all deeds as IDeed
     */
    public List<IDeed> getDeeds() {
        return deeds;
    }

    /**
     * Creates a list of deeds where the logged in account is registered as the giving account
     * and the receiving account is yet to be claimed.
     * A user has to be logged in before calling this method.
     *
     * @return a list of deeds with logged in account as giving account
     */

    public List<IDeed> getMyActiveOffers() {
        List<IDeed> myActiveOffers = new ArrayList<>();

        for (IDeed d : deeds) {
            if (loggedInAccount == d.getGivingAccount() && d.getReceivingAccount() == null) {
                myActiveOffers.add(d);
            }
        }
        return (myActiveOffers);
    }

    /**
     * Creates a list of deeds where the logged in account is registered as the receiving account
     * and the giving account is yet to be claimed.
     * A user has to be logged in before calling this method.
     *
     * @return a list of deeds with logged in account as receiving account
     */

    public List<IDeed> getMyActiveRequests() {
        List<IDeed> myActiveRequests = new ArrayList<>();

        for (IDeed d : deeds) {
            if (loggedInAccount == d.getReceivingAccount() && d.getGivingAccount() == null) {
                myActiveRequests.add(d);
            }
        }
        return (myActiveRequests);
    }


}
