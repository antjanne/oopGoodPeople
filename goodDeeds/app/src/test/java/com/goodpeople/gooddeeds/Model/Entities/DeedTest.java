package com.goodpeople.gooddeeds.Model.Entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeedTest {

    Account a;
    Deed o;
    Deed r;

    @Before
    public void initialize() {
        a = new Account("Test", 00000, "test@test.com", "123".hashCode());
        o = Deed.newOffer(a, "Subject", "Description");
        r = Deed.newRequest(a, "Subject", "Description");
    }

    @Test
    public void newOfferSetGivingAccount() {
        assertEquals(o.getGivingAccount(), a);
    }

    @Test
    public void newOfferNotSetReceivingAccount() {
        assertNull(o.getReceivingAccount());
    }

    @Test
    public void newOfferSetSubject() {
        assertEquals(o.getSubject(), "Subject");
    }

    @Test
    public void newOfferSetDescription() {
        assertEquals(o.getDescription(), "Description");
    }

    @Test
    public void newRequestNotSetGivingAccount() {
        assertNull(r.getGivingAccount());
    }

    @Test
    public void newRequestSetReceivingAccount() {
        assertEquals(r.getReceivingAccount(), a);
    }

    @Test
    public void newRequestSetSubject() {
        assertEquals(r.getSubject(), "Subject");
    }

    @Test
    public void newRequestSetDescription() {
        assertEquals(r.getDescription(), "Description");
    }
}