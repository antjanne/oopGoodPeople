package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GoodDeedsTest {

    GoodDeeds gd;
    Deed deed;
    Account loggedIn;
    @Before
    public void initialize(){
        gd = GoodDeeds.getGoodDeeds();
        gd.getAccounts().add(new Account("Test", 00000, "test@test.com", "123"));
     //   gd.getAccounts().add(new Account("Test2",0000,"test2@test.com","123"));
        gd.createOffer("Subject", "Description");

       // gd.getDeeds().add(new Deed(gd.getAccounts().get(0),"Luras","Kan lura dina test"));
        //gd.getDeeds().add(new Deed(gd.getAccounts().get(1),"Diskar","Diskar dina diskar"));

    }

    @After
    public void after() {

        gd.getAccounts().clear();
        gd.getDeeds().clear();
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
    public void getGoodDeeds() {

    }

    @Test
    public void getAccounts() {
        gd.createAccount("test3",0000,"test3@test3.com","123");
        assertEquals(gd.getAccounts().size(),2);
    }

    @Test
    public void createAccount() {
        gd.createAccount("test3",0000,"test3@test3.com","123");
        assertEquals(gd.getAccounts().size(), 2);

    }

    @Test
    public void validateAccountEmail() {
    }

    @Test
    public void login() {
    }

    @Test
    public void validateLogin() {


    }

    @Test
    public void getMyOffers() {
       assertEquals(gd.getMyOffers().size(),1);

    }

    @Test
    public void isLoggedIn() {
        gd.login("test@test.com", "123");
        loggedIn = gd.getAccounts().get(0);
        assertNotNull(loggedIn);
    }

    @Test
    public void createOffer() {
    assertEquals(gd.getDeeds().size(),1);
    }

    @Test
    public void getDeeds() {
    assertEquals(gd.getDeeds().size(),1);
    }
}