package com.goodpeople.gooddeeds.Model;

import org.junit.Test;


import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoodDeedsTest {
    GoodDeeds gd;
    AccountController ac;
    Deed deed;

    @Before
    public void initialize() {
        ac.createAccount("Olle", 41843, "olle@olle.se", "password" );
        ac.login("olle@olle.se", "password");
        

    }

    @Test
    public void testEditSubject() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        gd.editOffer(deed, "Changed", "description");
        assertFalse(subject == deed.getSubject());
        assertTrue(description == deed.getDescription());
    }

    @Test
    public void testEditDescription() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        gd.editOffer(deed, "subject", "Changed");
        assertFalse(description == deed.getDescription());
        assertTrue(subject == deed.getSubject());

    }
}