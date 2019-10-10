package com.goodpeople.gooddeeds.Model.Entities;

import android.os.Parcelable;

public interface IDeed {
    String getSubject();

    String getDescription();

    Account getGivingAccount();

}
