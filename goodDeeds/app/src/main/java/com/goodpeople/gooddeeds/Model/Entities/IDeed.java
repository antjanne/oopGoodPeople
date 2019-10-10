package com.goodpeople.gooddeeds.Model.Entities;

public interface IDeed {
    String getSubject();
    String getDescription();
    IAccount getGivingAccount();
    IAccount getReceivingAccount();


}
