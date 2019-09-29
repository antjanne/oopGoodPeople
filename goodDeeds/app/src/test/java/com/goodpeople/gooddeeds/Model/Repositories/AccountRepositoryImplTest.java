package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Account;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountRepositoryImplTest {

    AccountRepository repositoryTest;

    @Before
    public void setUp() throws Exception {
        repositoryTest = new AccountRepositoryImpl();
        repositoryTest.createAccount("richard", 41481, "rm@rm.se", "pass");
        repositoryTest.login("rm@rm.se", "pass");
    }

    @Test
    public void shouldCreateAccountLoginReturnLoggedinAccount() {
        repositoryTest.createAccount("richard", 41481, "rm123@rm.se", "pass123");
        repositoryTest.login("rm123@rm.se", "pass123");
        Account account = repositoryTest.getAccount();
        Assert.assertEquals(account.getPassword(), "pass123");
        Assert.assertEquals(account.getEmail(), "rm123@rm.se");
    }


    @Test
    public void shouldValidateLoginReturnTrue() {
        Assert.assertTrue(repositoryTest.validateLogin("rm@rm.se", "pass"));

    }

    @Test
    public void shouldValidateInvalidLoginReturnFalse() {
        Assert.assertFalse(repositoryTest.validateLogin("richard@rm.se", "pass"));

    }

    @Test
    public void shouldCheckIfIsLoggedInReturnTrue() {
        Assert.assertTrue(repositoryTest.isLoggedIn());
    }


    @Test
    public void shouldUpdatePassword() {
        repositoryTest.updatePassword("nyttpass");
        Assert.assertEquals(repositoryTest.getAccount().getPassword(), "nyttpass");
    }
}