package com.goodpeople.gooddeeds.Model.Entities;

import android.os.Parcelable;

public interface IAccount {

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    int getPostalCode();

    void setPostalCode(int postalCode);

    String getName();

    void setName(String name);
}
