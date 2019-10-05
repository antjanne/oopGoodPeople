package com.goodpeople.gooddeeds.Model.Entities;

import java.util.UUID;

public class Deed {

    private Account givingAccount;
    private String subject;
    private String description;

    public Deed(Account givingAccount, String subject, String description) {
        this.givingAccount = givingAccount;
        this.subject = subject;
        this.description = description;
    }

    public Account getGivingAccount() {
        return givingAccount;
    }

    public void setGivingAccount(Account givingAccount) {
        this.givingAccount = givingAccount;
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
