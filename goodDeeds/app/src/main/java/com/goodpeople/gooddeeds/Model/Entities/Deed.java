package com.goodpeople.gooddeeds.Model.Entities;

public class Deed {

    private Account givingAccount;
    private Account receivingAccount;
    private String subject;
    private String description;

    public Deed() {
    }

    public void newOffer(Account givingAccount, String subject, String description) {
        setGivingAccount(givingAccount);
        setSubject(subject);
        setDescription(description);
    }

    public void newRequest(Account receivingAccount, String subject, String description) {
        setReceivingAccount(receivingAccount);
        setSubject(subject);
        setDescription(description);
    }

    public Account getGivingAccount() {
        return givingAccount;
    }

    public void setGivingAccount(Account givingAccount) {
        this.givingAccount = givingAccount;
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
