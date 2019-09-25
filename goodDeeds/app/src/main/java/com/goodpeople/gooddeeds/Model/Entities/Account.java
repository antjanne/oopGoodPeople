package com.goodpeople.gooddeeds.Model.Entities;

import java.util.UUID;

public class Account {
    private final UUID id;
    private String name;
    private int postalCode;
    private String email;

    public Account(String name, int postalCode, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
    }

    public UUID getId() {
        return id;
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
}
