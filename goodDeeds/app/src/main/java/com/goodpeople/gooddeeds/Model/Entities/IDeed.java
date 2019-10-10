package com.goodpeople.gooddeeds.Model.Entities;

import android.os.Parcelable;

public interface IDeed extends Parcelable {
    String getSubject();

    String getDescription();

    Account getGivingAccount();

}
