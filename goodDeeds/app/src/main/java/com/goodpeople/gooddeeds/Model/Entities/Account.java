package com.goodpeople.gooddeeds.Model.Entities;

import android.os.Parcel;

public class Account implements IAccount {

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
    private String name;
    private int postalCode;
    private String email;
    private String password;

    public Account(String name, int postalCode, String email, String password) {
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
        this.password = password;
    }

    protected Account(Parcel in) {
        name = in.readString();
        postalCode = in.readInt();
        email = in.readString();
        password = in.readString();
    }

    /**
     * @return account name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set new name of account
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return account postal code
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode set new postal code for account
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return account email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email set new email for account
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return account password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password set new password for account
     */
    public void setPassword(String password) {
        this.password = password;
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
        dest.writeString(name);
        dest.writeInt(postalCode);
        dest.writeString(email);
        dest.writeString(password);
    }

}
