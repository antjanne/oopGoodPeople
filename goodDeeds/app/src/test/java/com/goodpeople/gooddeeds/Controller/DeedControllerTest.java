package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeedControllerTest {

    DeedController deedController;
    GoodDeeds goodDeeds;


    @Before
    public void initialize() {
        deedController = new DeedController();
        goodDeeds = GoodDeeds.getGoodDeeds();
        goodDeeds.createAccount("Test",0000,"test@test.se","123");
        goodDeeds.login("test@test.se","123");
        goodDeeds.createOffer("test","test");
    }

    @After
    public void after(){
        deedController.showOffersHandler().clear();
        goodDeeds.getDeeds().clear();
    }

    @Test
    public void showOffersHandler() {
        assertEquals(deedController.showOffersHandler().size(), 2);
    }

    @Test
    public void showMyOffersHandler() {
        assertEquals(deedController.showMyOffersHandler().size(),1);

    }

    @Test
    public void createOfferHandler() {
        deedController.createOfferHandler("test","test");
        assertEquals(goodDeeds.getDeeds().size(),3);
    }
}