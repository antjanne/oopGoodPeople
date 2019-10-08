package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Account;

public interface AccountRepository {

    void createAccount(String name, int postalCode, String email, String password);

    void login(String email, String password);

    boolean validateLogin(String email, String password);

    boolean isLoggedIn();

    Account getAccount();

    void updatePassword(String newPassword);

    boolean isEmailUsed(String email);

    void editAccount(String name, String email, int postalCode);


}
