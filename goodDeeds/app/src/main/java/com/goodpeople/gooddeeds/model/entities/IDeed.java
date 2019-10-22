package com.goodpeople.gooddeeds.model.entities;

import java.util.UUID;

/**
 * Defines the interface for Deed
 */

public interface IDeed {

  String getSubject();

  String getDescription();

  IAccount getGivingAccount();

  IAccount getReceivingAccount();

  UUID getUuid();
}
