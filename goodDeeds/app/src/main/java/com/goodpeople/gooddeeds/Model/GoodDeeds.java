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
        Account a = new Account("Anton",30597,"anton46304@gmail.com","ahah");
        Deed d = new Deed(a,"Gräsklipp","Jag hjälper gärna till att klippa gräsmattan i storgöteborg, ge mig en pling");
        Deed d2 = new Deed(a,"Hårklipp","Jag klipper gärna håret på folk! Ge mig en pling vetja!");

        accounts.add(a);
        loggedinAccount = a;
        deeds.add(d);
        deeds.add(d2);
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

    public List<Deed> getMyOffers(){
        List<Deed> myDeeds = new ArrayList<>();
        List<Deed> allDeeds = getDeeds();

        for(int a = 0; a < allDeeds.size(); a++){
            if(loggedinAccount == allDeeds.get(a).getGivingAccount()){
                myDeeds.add(allDeeds.get(a));
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
        Account givingAccount = loggedinAccount;
        Deed newDeed = new Deed(givingAccount, subject, description);
        deeds.add(newDeed);
    }


    public List<Deed> getDeeds() {
        return deeds;
    }
}
