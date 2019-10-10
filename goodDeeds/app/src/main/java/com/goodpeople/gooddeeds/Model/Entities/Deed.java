package com.goodpeople.gooddeeds.Model.Entities;

import android.os.Parcel;

public class Deed implements IDeed {

    //Parcelable
    public static final Creator<Deed> CREATOR = new Creator<Deed>() {
        @Override
        public Deed createFromParcel(Parcel in) {
            return new Deed(in);
        }

        @Override
        public Deed[] newArray(int size) {
            return new Deed[size];
        }
    };
    private Account givingAccount;
    private Account receivingAccount;
    private String subject;
    private String description;

    private Deed() {
    }

    private Deed(Parcel in) {
        givingAccount = in.readParcelable(Account.class.getClassLoader());
        receivingAccount = in.readParcelable(Account.class.getClassLoader());
        subject = in.readString();
        description = in.readString();
    }

    public static Deed newOffer(Account givingAccount, String subject, String description) {
        Deed d = new Deed();
        d.setGivingAccount(givingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        return d;
    }

    public static Deed newRequest(Account receivingAccount, String subject, String description) {
        Deed d = new Deed();
        d.setReceivingAccount(receivingAccount);
        d.setSubject(subject);
        d.setDescription(description);
        return d;
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

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(givingAccount, 0);
        dest.writeParcelable(receivingAccount, 0);
        dest.writeString(subject);
        dest.writeString(description);
    }


}
