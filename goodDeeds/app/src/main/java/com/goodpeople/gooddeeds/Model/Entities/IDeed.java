package com.goodpeople.gooddeeds.Model.Entities;

import android.os.Parcelable;

import java.util.UUID;

public interface IDeed {
    String getSubject();

    String getDescription();

    IAccount getGivingAccount();

    UUID getUuid();
}
