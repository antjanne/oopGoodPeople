package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.GoodDeeds;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeedControllerTest {

    private DeedController deedController;
    private GoodDeeds goodDeeds;

    @Before
    public void initialize() {
        deedController = new DeedController();
        goodDeeds = GoodDeeds.getGoodDeeds();
        goodDeeds.createAccount("Test1", 0000, "test1@test.se", "123");
        goodDeeds.createAccount("Test2", 0000, "test2@test.se", "123");
        goodDeeds.login("test1@test.se", "123");
        deedController.createOfferHandler("test", "test");
        deedController.createRequestHandler("test", "test");
        goodDeeds.login("test2@test.se", "123");
        deedController.createOfferHandler("test", "test");
        deedController.createRequestHandler("test", "test");
        goodDeeds.setCurrentdeed(goodDeeds.getDeeds().get(0).getUuid());
    }

    @After
    public void after() {
        goodDeeds.returnDeeds().clear();
    }

    @Test
    public void showMyActiveOffersHandler() {
        assertEquals(1, deedController.showMyActiveOffersHandler().size());
    }

    @Test
    public void showMyActiveRequestsHandler() {
        assertEquals(1, deedController.showMyActiveRequestsHandler().size());
    }

    @Test
    public void createOfferHandler() {
        assertEquals(4, goodDeeds.getDeeds().size());
    }

    @Test
    public void showAllActiveRequests() {
        assertEquals(deedController.showAllActiveRequests().size(), 2);
    }

    @Test
    public void showAllActiveOffers() {
        assertEquals(deedController.showAllActiveOffers().size(), 2);
    }

    @Test
    public void isMyActiveDeedHandler() {
        assertFalse(deedController.isMyActiveDeedHandler());
    }

    @Test
    public void isNotClaimed() {
        assertFalse(deedController.isClaimedHandler());
    }

    @Test
    public void isClaimedHandler() {
        deedController.claimDeedHandler();
        assertTrue(deedController.isClaimedHandler());
    }

    @Test
    public void claimDeedHandler() {
        deedController.claimDeedHandler();
        assertTrue(deedController.getCurrentDeedHandler().getGivingAccount() != null
                && deedController.getCurrentDeedHandler().getReceivingAccount() != null);
    }

    @Test
    public void isMyOwnDeedHandler() {
        goodDeeds.setCurrentdeed(goodDeeds.getDeeds().get(2).getUuid());
        assertTrue(deedController.isMyOwnDeedHandler());
    }


}