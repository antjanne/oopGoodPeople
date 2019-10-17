package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.IAccount;

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
    public void initialize() {
        goodDeeds = GoodDeeds.getGoodDeeds();
        goodDeeds.createAccount("Test", 00000, "test@test.com", "123");
        goodDeeds.login("test@test.com", "123");
        goodDeeds.createOffer("Subject1", "Description1");
        goodDeeds.createRequest("Subject2", "Description2");
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
        IAccount account = goodDeeds.getAccount();
        goodDeeds.updatePassword("newPassword");
        Assert.assertEquals(account.getPassword(), "newPassword");
    }

    @Test
    public void createOfferShouldBeAddedToDeeds() {
        assertEquals(2, goodDeeds.getDeeds().size());
    }

    @Test
    public void createOfferShouldStoreSubject() {
        assertEquals("Subject1", goodDeeds.getDeeds().get(0).getSubject());
    }

    @Test
    public void createOfferShouldStoreDescription() {
        assertEquals("Description1", goodDeeds.getDeeds().get(0).getDescription());
    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnTrue() {
        Assert.assertTrue(goodDeeds.isEmailUsed("test@test.com"));
    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnFalse() {
        Assert.assertFalse(goodDeeds.isEmailUsed("notUsed@email.se"));
    }

    @Test
    public void getAccounts() {
        goodDeeds.createAccount("test3", 0000, "test3@test3.com", "123");
        assertEquals(goodDeeds.getAccounts().size(), 2);
    }

    @Test
    public void createAccount() {
        goodDeeds.createAccount("test3", 0000, "test3@test3.com", "123");
        assertEquals(goodDeeds.getAccounts().size(), 2);

    }

    @Test
    public void getMyActiveOffers() { //TODO fixa så att den kollar just här
        assertEquals(goodDeeds.getMyActiveOffers().size(), 1);
    }

    @Test
    public void getMyActiveRequests() {
        assertEquals(1, goodDeeds.getMyActiveRequests().size());
    }

    @Test
    public void createOffer() {
        assertEquals(goodDeeds.getDeeds().size(), 2);
    }

    @Test
    public void getDeeds() {
        assertEquals(goodDeeds.getDeeds().size(), 2);
    }

    @Test
    public void shouldUpdateAccountDetails() {
        goodDeeds.editAccount("newName", "newEmail@email.se", 12345);
        Assert.assertEquals(goodDeeds.getAccount().getName(), "newName");
        Assert.assertEquals(goodDeeds.getAccount().getEmail(), "newEmail@email.se");
        Assert.assertEquals(goodDeeds.getAccount().getPostalCode(), 12345);
        assertEquals(goodDeeds.getDeeds().size(), 2);
    }

    @Test
    public void logout() {
        goodDeeds.logout();
        assertFalse(goodDeeds.isLoggedIn());
    }

    @Test
    public void getActiveRequests() {
        assertEquals(goodDeeds.getActiveRequests().size(),1);
    }

    @Test
    public void getActiveOffers() {
        assertEquals(goodDeeds.getActiveOffers().size(),1);
    }
}
