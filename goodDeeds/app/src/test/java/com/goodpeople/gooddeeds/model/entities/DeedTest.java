package com.goodpeople.gooddeeds.model.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeedTest {

    private Account a;
    private Deed o;
    private Deed r;

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

    @Test
    public void getGivingAccount() {
        assertEquals(o.getGivingAccount(), a);
    }

    @Test
    public void setGivingAccount() {
        Account b = new Account("b", 00000, "b@b.b", "123".hashCode());
        o.setGivingAccount(b);
        assertEquals(o.getGivingAccount(), b);
    }

    @Test
    public void getReceivingAccount() {
        assertEquals(r.getReceivingAccount(), a);
    }

    @Test
    public void setReceivingAccount() {
        Account b = new Account("b", 00000, "b@b.b", "123".hashCode());
        r.setReceivingAccount(b);
        assertEquals(r.getReceivingAccount(), b);
    }

    @Test
    public void getSubject() {
        assertEquals(o.getSubject(), "Subject");
    }

    @Test
    public void setSubject() {
        o.setSubject("Subject2");
        assertEquals(o.getSubject(), "Subject2");
    }

    @Test
    public void getDescription() {
        assertEquals(o.getDescription(), "Description");
    }

    @Test
    public void setDescription() {
        o.setDescription("Description2");
        assertEquals(o.getDescription(), "Description2");
    }
}