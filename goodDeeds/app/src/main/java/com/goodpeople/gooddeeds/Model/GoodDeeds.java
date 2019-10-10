package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.ArrayList;
import java.util.List;

public class GoodDeeds {

    private static GoodDeeds goodDeeds;

    private List<IDeed> deeds = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private Account loggedinAccount;

    private GoodDeeds() {
        /*Account a = new Account("Anton",30597,"anton46304@gmail.com","ahah");
        Deed d = Deed.newOffer(a,"Gräsklipp","Jag hjälper gärna till att klippa gräsmattan i storgöteborg, ge mig en pling");
        Deed d2 = Deed.newOffer(a,"Hårklipp","Jag klipper gärna håret på folk! Ge mig en pling vetja!");

        accounts.add(a);
        loggedinAccount = a;
        deeds.add(d);
        deeds.add(d2);*/
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

    /**
     * Creates a list of deeds with only the logged in account as owner of the deed.
     * Filters all deeds to only the ones the logged in account is owner of.
     * A user has to be logged in before calling this method.
     *
     * @return a list of deeds with logged in account as owner
     */
    public List<IDeed> getMyOffers(){
        List<IDeed> myDeeds = new ArrayList<>();

        for(IDeed d : deeds){
            if(loggedinAccount == d.getGivingAccount()){
                myDeeds.add(d);
            }
        }
        return (myDeeds);
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
        Deed newOffer = Deed.newOffer(loggedinAccount, subject, description);
        deeds.add(newOffer);
    }

    /**
     * Returns a list of all Deeds in the form of IDeed
     * @return all IDeeds
     */
    public List<IDeed> getDeeds() {
        return deeds;
    }
}
