package com.goodpeople.gooddeeds.Model.Entities;

public interface IAccount {

    String getEmail();
    String getPassword();
    void setPassword(String password);
    void setEmail(String email);
    void setName(String name);
    void setPostalCode(int postalCode);
    int getPostalCode();
    String getName();
}
