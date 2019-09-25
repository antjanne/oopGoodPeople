package com.goodpeople.gooddeeds.Model.Entities;

import java.util.UUID;

public class Deed {

    private final UUID id;
    private Account givingAccount;
    private String subject;
    private String description;

    public Deed(Account givingAccount, String subject, String description) {
        this.id = UUID.randomUUID();
        this.givingAccount = givingAccount;
        this.subject = subject;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public Account getGivingAccount() {
        return givingAccount;
    }

    public void setGivingAccount(Account receivingAccount) {
        this.givingAccount = receivingAccount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
