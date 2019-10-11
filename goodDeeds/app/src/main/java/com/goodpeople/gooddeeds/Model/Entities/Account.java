package com.goodpeople.gooddeeds.Model.Entities;



/**
 * Class Account: represents an account. Initializes fields name, postalCode,
 * email and password when an account is created.
 */

public class Account implements IAccount{


    private String name;
    private int postalCode;
    private String email;
    private String password;


    public Account(String name, int postalCode, String email, String password) {
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
        this.password = password;
    }


    /**
     * @return account name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set new name of account
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return account postal code
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode set new postal code for account
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return account email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email set new email for account
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return account password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password set new password for account
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
