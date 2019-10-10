package com.goodpeople.gooddeeds.Model.Entities;

public class Deed implements IDeed {

    private Account givingAccount;
    private Account receivingAccount;
    private String subject;
    private String description;

    private Deed() {
    }

    /**
     * Method for creating a new offer, the given account is registered as the givingAccount.
     *
     * @param givingAccount the account that wants to give the deed
     * @param subject the subject of the offer
     * @param description the description of the offer
     * @return the created offer
     */
    public static Deed newOffer(Account givingAccount, String subject, String description) {
        Deed d = new Deed();
        d.setGivingAccount(givingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        return d;
    }

    /**
     * Method for creating a new request, the given account is registered as the receivingAccount.
     *
     * @param receivingAccount the account that wants to receive the deed
     * @param subject the subject of the request
     * @param description the description of the request
     * @return the created request
     */
    public static Deed newRequest(Account receivingAccount, String subject, String description) {
        Deed d = new Deed();
        d.setReceivingAccount(receivingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        return d;
    }

    //TODO
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
