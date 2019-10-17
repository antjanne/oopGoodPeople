package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.IAccount;

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
        IAccount account = repositoryTest.getAccount();
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

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnFalse() {
        Assert.assertFalse(repositoryTest.isEmailUsed("notUsed@email.se"));
    }

    @Test
    public void shouldValidateIfEmailIsAlreadyUsedReturnTrue() {
        Assert.assertTrue(repositoryTest.isEmailUsed("rm@rm.se"));
    }

    @Test
    public void shouldEditAccountAndReturnNewValues() {
        repositoryTest.editAccount("newName", "newEmail@email.se", 12345);
        Assert.assertEquals(repositoryTest.getAccount().getName(), "newName");
        Assert.assertEquals(repositoryTest.getAccount().getEmail(), "newEmail@email.se");
        Assert.assertEquals(repositoryTest.getAccount().getPostalCode(), 12345);
    }

    @Test
    public void logout() {
        repositoryTest.logout();
        Assert.assertFalse(repositoryTest.isLoggedIn());
    }
}