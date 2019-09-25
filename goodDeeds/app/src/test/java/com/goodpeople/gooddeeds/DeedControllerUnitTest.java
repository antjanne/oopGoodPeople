package com.goodpeople.gooddeeds;

import com.goodpeople.gooddeeds.Controller.DeedController;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeedControllerUnitTest {

    DeedController deedController;
    GoodDeeds goodDeeds;

    @Before
    public void setup(){
        deedController = new DeedController();
        goodDeeds = GoodDeeds.getGoodDeeds();
    }

    @Test
    public void testAccountCreation(){
        deedController.createAccount("richard",414,"rm@rm.se","pass123");
        Assert.assertEquals(goodDeeds.getAccounts().size(),1);
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getEmail(),"rm@rm.se");
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getName(),"richard");
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getPassword(),"pass123");
        Assert.assertEquals(goodDeeds.getAccounts().get(0).getPostalCode(),414);

    }
}
