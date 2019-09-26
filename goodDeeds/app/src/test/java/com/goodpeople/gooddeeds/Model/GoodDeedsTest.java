package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class GoodDeedsTest {

    GoodDeeds gd;
    Account a;
    UUID id;

    @Before
    public void initialize(){
        gd = GoodDeeds.getGoodDeeds();
        gd.getAccounts().add(new Account("Test", 00000, "test@test.com", "123"));
        a = gd.getAccounts().get(0);
        id = a.getId();

        try {
            gd.addOffer(id, "Subject", "Description");
        } catch (Exception e) {
            // TODO what to do here?
        }
    }

    @Test
    public void addOfferWithInvalidGivingAccountId() {
        UUID invalidId = UUID.randomUUID();
        try {
            gd.addOffer(invalidId, "Subject", "Description");
            fail("Adding offer with invalid id should throw exception");
        } catch (Exception e) {
            assertTrue(e.getMessage() == "Invalid account id");
        }
    }

    @Test
    public void addOfferIdStored() {
        assertTrue("The id of the giving account should be stored.", gd.getDeeds().get(0).getGivingAccount().getId().equals(id));
    }

    @Test
    public void addOfferSubjectStored() {
        assertTrue("The subject of the offer should be stored", gd.getDeeds().get(0).getSubject() == "Subject");
    }

    @Test
    public void addOfferDescriptionStored() {
        assertTrue("The description of the offer should be stored", gd.getDeeds().get(0).getDescription() == "Description");
    }


}