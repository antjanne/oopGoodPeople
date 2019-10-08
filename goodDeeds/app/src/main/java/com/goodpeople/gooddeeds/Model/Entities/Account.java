package com.goodpeople.gooddeeds.Model.Entities;

public class Account {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
