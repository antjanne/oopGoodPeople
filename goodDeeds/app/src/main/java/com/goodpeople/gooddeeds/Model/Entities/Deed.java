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
    private int karmaPoints;
    private boolean doneDeed;

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
        d.karmaPoints = 50;
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

    /**
     * @return the account that is volunteering to do this deed
     */
    public IAccount getGivingAccount() {
        return givingAccount;
    }

    /**
     * @param givingAccount the account that is volunteering to do this deed
     */
    public void setGivingAccount(IAccount givingAccount) {
        this.givingAccount = givingAccount;
    }

    /**
     * @return the account that will be getting help with this deed
     */
    public IAccount getReceivingAccount() {
        return receivingAccount;
    }

    /**
     * @param receivingAccount the account that will be getting help with this deed
     */
    public void setReceivingAccount(IAccount receivingAccount) {
        this.receivingAccount = receivingAccount;
    }

    /**
     * @return the subject of a deed
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject of a deed
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the description of a deed
     */
    public String getDescription() {
        return description;
    }

    /**
     * the description of a deed
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the uuid of a deed
     */
    public UUID getUuid() {
        return uuid;
    }

    private void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the amount of karmaPoint asked/offered for a deed
     */
    public int getKarmaPoints() {
        return this.karmaPoints;
    }

    private void setKarmaPoints(int karmaPoints) {
        this.karmaPoints = karmaPoints;
    }

    /**
     * Method for marking a deed as done
     */
    public void deedIsDone() {
        doneDeed = true;
    }


}
