package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Entities.Account;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AccountControllerTest {
    AccountController accountController;

    @Before
    public void setUp() {
        accountController = new AccountController();
        accountController.createAccount("richard", 41481, "rm123@rm.se", "pass123");
        accountController.login("rm123@rm.se", "pass123");
    }


    @Test
    public void shouldCreateAccountLoginReturnLoggedinAccount() {
        Account account = accountController.accountHandler();
        Assert.assertEquals(account.getPassword(), "pass123");
        Assert.assertEquals(account.getEmail(), "rm123@rm.se");
    }


    @Test
    public void shouldValidateValidLogInReturnTrue() {
        Assert.assertTrue(accountController.validateLogin("rm123@rm.se", "pass123"));
    }

    @Test
    public void shouldValidateInvalidEmailLogInReturnFalse() {
        Assert.assertFalse(accountController.validateLogin("wrong.email", "pass123"));
    }

    @Test
    public void shouldValidateInvalidPasswordLogInReturnFalse() {
        Assert.assertFalse(accountController.validateLogin("rm123@rm.se", "wrongPassword"));
    }

    @Test
    public void shouldTestIfLoggedInReturnTrue() {
        Assert.assertTrue(accountController.isLoggedIn());
    }


    @Test
    public void shouldUpdatePasswordStoreNewPassword() {
        accountController.updatePasswordHandler("newPassword");
        Assert.assertEquals(accountController.accountHandler().getPassword(), "newPassword");

    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnTrue() {
        Assert.assertTrue(accountController.isEmailUsedHandler("rm123@rm.se"));
    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnFalse() {
        Assert.assertFalse(accountController.isEmailUsedHandler("notUsed@email.se"));
    }
}