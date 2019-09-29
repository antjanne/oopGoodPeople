package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoodDeedsTest {

    GoodDeeds goodDeeds;

    @Before
    public void setUp() throws Exception {
        goodDeeds = GoodDeeds.getGoodDeeds();
        goodDeeds.createAccount("richard", 41481, "rm@rm.se", "pass");
        goodDeeds.login("rm@rm.se", "pass");
    }

    @After
    public void after() {
        goodDeeds.getAccounts().clear();
    }


    @Test

    public void shouldGetAccountsSize1() {
        Assert.assertEquals(goodDeeds.getAccounts().size(), 1);
    }

    @Test
    public void shouldCheckIfLoggedInReturnTrue() {
        Assert.assertTrue(goodDeeds.isLoggedIn());
    }

    @Test
    public void shouldValidateLoginReturnTrue() {
        Assert.assertTrue(goodDeeds.validateLogin("rm@rm.se", "pass"));
    }

    @Test
    public void shouldValidateInvalidEmailLoginReturnFalse() {
        Assert.assertFalse(goodDeeds.validateLogin("wrong.email", "pass"));
    }

    @Test
    public void shouldValidateInvalidPasswordLoginReturnFalse() {
        Assert.assertFalse(goodDeeds.validateLogin("rm@rm.se", "pass123"));
    }

    @Test
    public void updatePassword() {
        Account account = goodDeeds.getAccount();
        goodDeeds.updatePassword("newPassword");
        Assert.assertEquals(account.getPassword(), "newPassword");
    }
}