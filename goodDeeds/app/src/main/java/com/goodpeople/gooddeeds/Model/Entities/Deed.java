package com.goodpeople.gooddeeds.Model.Entities;


import java.util.UUID;

/**
 * Class Deed: represents a deed, which can be either a request or an offer.
 * Type of deed is set by initializing either parameter givingAccount or receivingAccount
 * to the logged in account as the deed is created.
 */

public class Deed implements IDeed {

    private IAccount givingAccount;
    private IAccount receivingAccount;

    private String subject;
    private String description;
    private UUID uuid;

    private Deed() {
    }

    /**
     * Method for creating a new offer, the given account is registered as the givingAccount.
     *
     * @param givingAccount the account that wants to give the deed
     * @param subject       the subject of the offer
     * @param description   the description of the offer
     * @return the created offer
     */
    public static Deed newOffer(IAccount givingAccount, String subject, String description) {

        Deed d = new Deed();
        d.setGivingAccount(givingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        d.setUuid(UUID.randomUUID());
        return d;
    }

    /**
     * Method for creating a new request, the given account is registered as the receivingAccount.
     *
     * @param receivingAccount the account that wants to receive the deed
     * @param subject          the subject of the request
     * @param description      the description of the request
     * @return the created request
     */
    public static Deed newRequest(IAccount receivingAccount, String subject, String description) {
        Deed d = new Deed();
        d.setReceivingAccount(receivingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        d.setUuid(UUID.randomUUID());
        return d;
    }

    public IAccount getGivingAccount() {
        return givingAccount;
    }

    private void setGivingAccount(IAccount givingAccount) {
        this.givingAccount = givingAccount;
    }

    public IAccount getReceivingAccount() {
        return receivingAccount;
    }

    private void setReceivingAccount(IAccount receivingAccount) {
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

    private void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
