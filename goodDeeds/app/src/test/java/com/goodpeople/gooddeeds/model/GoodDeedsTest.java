package com.goodpeople.gooddeeds.model;

import com.goodpeople.gooddeeds.model.entities.Deed;


import com.goodpeople.gooddeeds.model.entities.IAccount;
import com.goodpeople.gooddeeds.model.entities.IDeed;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class GoodDeedsTest {


    private GoodDeeds gd;
    private IDeed deed;

    @Before
    public void initialize() {
        gd = GoodDeeds.getGoodDeeds();
        gd.createAccount("Test", 00000, "test@test.com", "123");
        gd.login("test@test.com", "123");
        gd.createOffer("Subject", "Description");
        gd.createRequest("Subject1", "Description1");
        deed = gd.getIDeeds().get(0);
        gd.setCurrentdeed(deed.getUuid());
    }

    @After
    public void after() {
        gd.getIDeeds().remove(0);
        gd.getAccounts().clear();
        gd.deeds.clear();
        gd = null;

    }


    @Test
    public void shouldGetAccountsSize1() {
        assertEquals(gd.getAccounts().size(), 1);
    }

    @Test
    public void shouldCheckIfLoggedInReturnTrue() {
        assertTrue(gd.isLoggedIn());
    }

    @Test
    public void shouldValidateLoginReturnTrue() {
        assertTrue(gd.validateLogin("test@test.com", "123"));
    }

    @Test
    public void shouldValidateInvalidEmailLoginReturnFalse() {
        assertFalse(gd.validateLogin("wrong.email", "123"));
    }

    @Test
    public void shouldValidateInvalidPasswordLoginReturnFalse() {
        assertFalse(gd.validateLogin("test@test.com", "pass123"));
    }

    @Test
    public void updatePassword() {

        IAccount account = gd.getAccount();
        gd.updatePassword("newPassword");
        Assert.assertEquals(account.getPassword(), "newPassword".hashCode());

    }

    @Test
    public void createOfferShouldStoreSubject() {
        assertEquals("Subject", gd.getIDeeds().get(0).getSubject());
    }

    @Test
    public void createOfferShouldStoreDescription() {
        assertEquals("Description", gd.getIDeeds().get(0).getDescription());
    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnTrue() {
        Assert.assertTrue(gd.isEmailUsed("test@test.com"));
    }

    @Test
    public void testEditSubject() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        gd.editDeed("Changed", "Description");
        assertNotEquals(subject, deed.getSubject());
        assertEquals(description, deed.getDescription());
    }

    @Test
    public void testEditDescription() {
        String subject = deed.getSubject();
        String description = deed.getDescription();
        gd.editDeed("Subject", "Changed");
        assertNotEquals(description, deed.getDescription());
        assertEquals(subject, deed.getSubject());
    }

    @Test
    public void testEditOnlyYourOwnDeeds() {
        gd.createAccount("SomeoneElse", 00000, "test@test.com", "123");
        IAccount newAccount = gd.getAccounts().get(1);
        Deed.newOffer(newAccount, "subject", "description");
        gd.editDeed("Changed", "Changed");
        assertSame("Changed", deed.getSubject());
        assertSame("Changed", deed.getDescription());
    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnFalse() {
        Assert.assertFalse(gd.isEmailUsed("notUsed@email.se"));
    }

    @Test
    public void getAccounts() {
        gd.createAccount("test3", 0000, "test3@test3.com", "123");
        assertEquals(gd.getAccounts().size(), 2);
    }

    @Test
    public void createAccount() {
        gd.createAccount("test3", 0000, "test3@test3.com", "123");
        assertEquals(gd.getAccounts().size(), 2);

    }

    @Test
    public void getMyActiveOffers() {
        assertEquals(gd.getMyActiveOffers().size(), 1);
    }

    @Test
    public void getMyActiveRequests() {
        assertEquals(1, gd.getMyActiveRequests().size());
    }


    @Test
    public void getIDeeds() {
        assertEquals(gd.getIDeeds().size(), 2);
    }

    @Test
    public void shouldUpdateAccountDetails() {
        gd.editAccount("newName", "newEmail@email.se", 12345);
        Assert.assertEquals(gd.getAccount().getName(), "newName");
        Assert.assertEquals(gd.getAccount().getEmail(), "newEmail@email.se");
        Assert.assertEquals(gd.getAccount().getPostalCode(), 12345);
    }

    @Test
    public void logout() {
        gd.logout();
        assertFalse(gd.isLoggedIn());
    }

    @Test
    public void getActiveRequests() {
        assertEquals(gd.getActiveRequests().size(), 1);
    }

    @Test
    public void getActiveOffers() {
        assertEquals(1, gd.getActiveOffers().size());
    }

    @Test
    public void claimDeedOfferEdition() {
        gd.claimDeed();
        assertTrue((deed.getGivingAccount() != null) &&
                (deed.getReceivingAccount() != null));
    }

    @Test
    public void claimDeedRequestEdition() {
        gd.setCurrentdeed(gd.getIDeeds().get(1).getUuid());
        gd.claimDeed();
        assertTrue((gd.getCurrentDeed().getGivingAccount() != null) &&
                (gd.getCurrentDeed().getReceivingAccount() != null));
    }

    @Test
    public void isNotClaimed() {
        assertFalse(gd.isClaimed());
    }

    @Test
    public void isClaimed() {
        gd.claimDeed();
        assertTrue(gd.isClaimed());
    }

    @Test
    public void isMyOwnDeedOfferEdition() {
        assertTrue(gd.isMyOwnDeed());
    }

    @Test
    public void isMyOwnDeedRequestEdition() {
        gd.setCurrentdeed(gd.getIDeeds().get(1).getUuid());
        assertTrue(gd.isMyOwnDeed());
    }

    @Test
    public void isMyActiveDeed() {
        assertTrue(gd.isMyActiveDeed());
    }

    @Test
    public void deleteCurrentDeed() {
        Assert.assertTrue(gd.getIDeeds().contains(deed));
        gd.deleteCurrentDeed();
        Assert.assertFalse(gd.getIDeeds().contains(deed));
    }

    @Test(expected = RuntimeException.class)
    public void deleteCurrentDeedException() {
        gd.createAccount("test", 12345, "test@mail.test", "test123");
        gd.login("test@mail.test", "test123");
        gd.deleteCurrentDeed();

    }


    @Test(expected = NullPointerException.class)
    public void setCurrentDeedException() {
        gd.setCurrentdeed(new UUID(1234567890, 1234567890));
    }
}

