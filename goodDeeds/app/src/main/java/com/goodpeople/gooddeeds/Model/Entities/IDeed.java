package com.goodpeople.gooddeeds.Model.Entities;

public interface IDeed {

    /**
     * Defines the interface for Deed
     */

    /**
     * @return The subject of a deed
     */
    String getSubject();

    /**
     * @return The description of a deed
     */
    String getDescription();

    /**
     * @return The account that is registered as a giving account of a deed
     */
    Account getGivingAccount();

}
