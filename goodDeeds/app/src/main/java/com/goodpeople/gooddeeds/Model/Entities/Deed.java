package com.goodpeople.gooddeeds.Model.Entities;

import java.util.UUID;

public class Deed {

    private final UUID id;
    private Account receivingAccount;
    private String subject;
    private String description;

    public Deed(Account receivingAccount, String subject, String description) {
        this.id = UUID.randomUUID();
        this.receivingAccount = receivingAccount;
        this.subject = subject;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public Account getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(Account receivingAccount) {
        this.receivingAccount = receivingAccount;
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
