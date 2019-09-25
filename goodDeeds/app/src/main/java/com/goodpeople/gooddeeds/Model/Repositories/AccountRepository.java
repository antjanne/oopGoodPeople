package com.goodpeople.gooddeeds.Model.Repositories;

public interface AccountRepository {

    void createAccount(String name, int postalCode, String email, String password);

    boolean validateAccountEmail(String email);

    void login(String email, String password);

    boolean validateLogin(String email, String password);

    boolean isLoggedIn();
}
