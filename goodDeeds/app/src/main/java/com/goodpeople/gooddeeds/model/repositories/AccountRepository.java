package com.goodpeople.gooddeeds.model.repositories;

import com.goodpeople.gooddeeds.model.entities.IAccount;

/**
 * Defines the interface for handling account data between service and data handler
 */

public interface AccountRepository {

    void createAccount(String name, int postalCode, String email, String password);

    void login(String email, String password);

    boolean validateLogin(String email, String password);

    boolean isLoggedIn();

    IAccount getAccount();

    void updatePassword(String newPassword);

    boolean isEmailUsed(String email);

    void editAccount(String name, String email, int postalCode);

    void logout();
}
