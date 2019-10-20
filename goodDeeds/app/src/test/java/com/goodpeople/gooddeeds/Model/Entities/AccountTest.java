package com.goodpeople.gooddeeds.Model.Entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    private IAccount account;

    @Before

    public void setUp() {
        account = new Account("richard", 41481, "rm@rm.se", "pass".hashCode());
    }


    @Test
    public void setName() {
        account.setName("bengt");
        Assert.assertEquals(account.getName(), "bengt");
    }

    @Test
    public void setPostalCode() {
        account.setPostalCode(41311);
        Assert.assertEquals(account.getPostalCode(), 41311);
    }

    @Test
    public void setEmail() {
        account.setEmail("mail@mail.se");
        Assert.assertEquals(account.getEmail(), "mail@mail.se");
    }


    @Test
    public void setPassword() {
        account.setPassword("lösen".hashCode());
        Assert.assertEquals(account.getPassword(), "lösen".hashCode());
    }
}