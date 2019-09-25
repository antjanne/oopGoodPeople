package com.goodpeople.gooddeeds;

import com.goodpeople.gooddeeds.Controller.AccountController;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountControllerUnitTest {

    AccountController accountController;
    GoodDeeds goodDeeds;


    @Before
    public void setup() {
        accountController = new AccountController();
        goodDeeds = GoodDeeds.getGoodDeeds();
        accountController.createAccount("richard", 414, "rm@rm.se", "pass123");
    }

    @Test
    public void testAccountCreation() {
        Assert.assertEquals(goodDeeds.getAccounts().size(), 1);
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getEmail(), "rm@rm.se");
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getName(), "richard");
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getPassword(), "pass123");
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getPostalCode(), 414);

    }

    @Test
    public void testValidateEmail() {
        Assert.assertFalse(accountController.validateAccountEmail("asdfafs.se"));
        Assert.assertTrue(accountController.validateAccountEmail("rm@rm.se"));
    }

    @Test
    public void testValidateLogin() {
        Assert.assertTrue(accountController.validateLogin("rm@rm.se", "pass123"));
        Assert.assertFalse(accountController.validateLogin("rm@rm.se", "wrongpass"));
        Assert.assertFalse(accountController.validateLogin("wrongemail", "pass123"));
    }

    @Test
    public void login() {
        accountController.login("rm@rm.se", "pass123");
        Assert.assertTrue(accountController.isLoggedIn());
    }
}
