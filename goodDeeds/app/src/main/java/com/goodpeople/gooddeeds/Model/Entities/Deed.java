package com.goodpeople.gooddeeds.Model.Entities;


/**
 * Class Deed: represents a deed, which can be either a request or an offer.
 * Type of deed is set by initializing either parameter givingAccount or receivingAccount
 * to the logged in account as the deed is created.
 */


import java.util.UUID;


public class Deed implements IDeed {


    private IAccount givingAccount;
    private IAccount receivingAccount;

    private String subject;
    private String description;
    private UUID uuid;

    private Deed() {
    }

    public static Deed newOffer(IAccount givingAccount, String subject, String description) {

        Deed d = new Deed();
        d.setGivingAccount(givingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        d.setUuid(UUID.randomUUID());
        return d;
    }

    public static Deed newRequest(IAccount receivingAccount, String subject, String description) {
        Deed d = new Deed();
        d.setReceivingAccount(receivingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        return d;
    }

    public IAccount getGivingAccount() {
        return givingAccount;
    }

    public void setGivingAccount(IAccount givingAccount) {
        this.givingAccount = givingAccount;
    }

    public IAccount getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(IAccount receivingAccount) {
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
