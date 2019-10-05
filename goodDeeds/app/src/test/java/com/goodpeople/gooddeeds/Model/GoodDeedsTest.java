package com.goodpeople.gooddeeds.Model;


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
        gd = GoodDeeds.getGoodDeeds();
        ac = new AccountController();
        ac.createAccount("Test", 00000, "test@test.com", "123");
        ac.login("Test", "123");
        gd.createOffer("Subject", "Description");
        deed = gd.getDeeds().get(0);
        

    }

    @After
    public void after() {
        gd.getDeeds().remove(0);
        gd = null;
    }

    @Test
    public void createOfferShouldBeAddedToOffers() {
        assertEquals(1, gd.getDeeds().size());
    }

    @Test
    public void createOfferShouldStoreSubject() {
        assertEquals("Subject", gd.getDeeds().get(0).getSubject());
    }

    @Test
    public void createOfferShouldStoreDescription() {
        assertEquals("Description", gd.getDeeds().get(0).getDescription());
    }

    @Test
    public void testEditSubject() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        gd.editOffer(deed, "Changed", "Description");
        assertFalse(subject == deed.getSubject());
        assertTrue(description == deed.getDescription());
    }

    @Test
    public void testEditDescription() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        gd.editOffer(deed, "Subject", "Changed");
        assertFalse(description == deed.getDescription());
        assertTrue(subject == deed.getSubject());
    }

    @Test
    public  void testEditOnlyYourOwnDeeds() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        ac.createAccount("SomeoneElse", 00000, "test@test.com", "123");
        Account newAccount = gd.getAccounts().get(1);
        deed.setGivingAccount(newAccount);
        gd.editOffer(deed, "Changed", "Changed");
        assertSame(subject, deed.getSubject());
        assertSame(description, deed.getDescription());

    }
}