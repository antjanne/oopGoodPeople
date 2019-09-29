package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GoodDeedsTest {

    GoodDeeds goodDeeds;

    @Before
    public void setUp() throws Exception {
        goodDeeds = GoodDeeds.getGoodDeeds();
        goodDeeds.createAccount("Test", 00000, "test@test.com", "123");
        goodDeeds.login("test@test.com", "123");
        goodDeeds.createOffer("Subject", "Description");
    }

    @After
    public void after() {
        goodDeeds.getAccounts().clear();
        goodDeeds.getDeeds().clear();
    }


    @Test
    public void shouldGetAccountsSize1() {
        assertEquals(goodDeeds.getAccounts().size(), 1);
    }

    @Test
    public void shouldCheckIfLoggedInReturnTrue() {
        assertTrue(goodDeeds.isLoggedIn());
    }

    @Test
    public void shouldValidateLoginReturnTrue() {
        assertTrue(goodDeeds.validateLogin("test@test.com", "123"));
    }

    @Test
    public void shouldValidateInvalidEmailLoginReturnFalse() {
        assertFalse(goodDeeds.validateLogin("wrong.email", "123"));
    }

    @Test
    public void shouldValidateInvalidPasswordLoginReturnFalse() {
        assertFalse(goodDeeds.validateLogin("test@test.com", "pass123"));
    }

    @Test
    public void updatePassword() {
        Account account = goodDeeds.getAccount();
        goodDeeds.updatePassword("newPassword");
        Assert.assertEquals(account.getPassword(), "newPassword");
    }

    @Test
    public void createOfferShouldBeAddedToOffers() {
        assertEquals(1, goodDeeds.getDeeds().size());
    }

    @Test
    public void createOfferShouldStoreSubject() {
        assertEquals("Subject", goodDeeds.getDeeds().get(0).getSubject());
    }

    @Test
    public void createOfferShouldStoreDescription() {
        assertEquals("Description", goodDeeds.getDeeds().get(0).getDescription());
    }
}

