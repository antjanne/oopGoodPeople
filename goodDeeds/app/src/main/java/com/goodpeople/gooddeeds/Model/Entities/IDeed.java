package com.goodpeople.gooddeeds.Model.Entities;

import java.util.UUID;

public interface IDeed {
    String getSubject();
    String getDescription();
    IAccount getGivingAccount();
    IAccount getReceivingAccount();
    UUID getUuid();
}
