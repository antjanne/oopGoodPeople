package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.IAccount;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

public class AccountRepositoryImpl implements AccountRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    /**
     * Creates account by calling method in GoodDeeds
     *
     * @param name       name of person creating the account
     * @param postalCode postal code of person creating the account
     * @param email      Email of person creating the account
     * @param password   Password of person creating the account
     */
    @Override
    public void createAccount(String name, int postalCode, String email, String password) {
        goodDeeds.createAccount(name, postalCode, email, password);
    }

    /**
     * Logs in account by calling method in GoodDeeds
     *
     * @param email    email input
     * @param password password input
     */
    @Override
    public void login(String email, String password) {
        goodDeeds.login(email, password);
    }

    /**
     * Validates login details by calling method in GoodDeeds
     *
     * @param email    email input
     * @param password password input
     * @return boolean that validates whether there is a match of account email + password
     */
    @Override
    public boolean validateLogin(String email, String password) {
        return goodDeeds.validateLogin(email, password);
    }

    /**
     * @return boolean that specifies whether the user is logged in or not
     */
    @Override
    public boolean isLoggedIn() {
        return goodDeeds.isLoggedIn();
    }

    /**
     * @return returns logged in account-object
     */
    @Override
    public IAccount getAccount() {
        return goodDeeds.getAccount();
    }

    /**
     * Updates the logged in accounts password by calling method in GoodDeeds
     *
     * @param newPassword the new password
     */
    @Override
    public void updatePassword(String newPassword) {
        goodDeeds.updatePassword(newPassword);
    }

    /**
     * @param email email input
     * @return boolean whether the email is used by another account or not
     */
    @Override
    public boolean isEmailUsed(String email) {
        return goodDeeds.isEmailUsed(email);
    }

    /**
     * Updates account details by calling method in GoodDeeds
     *
     * @param name       potentially new account name
     * @param email      potentially new account email
     * @param postalCode potentially new postal code
     */
    @Override
    public void editAccount(String name, String email, int postalCode) {
        goodDeeds.editAccount(name, email, postalCode);
    }


}
