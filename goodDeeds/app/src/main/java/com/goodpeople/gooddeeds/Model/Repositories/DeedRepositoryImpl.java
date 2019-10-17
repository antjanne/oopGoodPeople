package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.List;
import java.util.UUID;

/**
 * Handles the layer between service and data handler
 */

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    @Override
    public List<IDeed> getDeeds() {
        return goodDeeds.getDeeds();
    }

    /**
     * Method for getting the active offers for a logged in account.
     * A account has to be logged in before calling this method.
     *
     * @return the list of active offers for the logged in account
     */
    @Override
    public List<IDeed> getMyActiveOffers() {
        return goodDeeds.getMyActiveOffers();
    }

    /**
     * Method for getting the active requests for a logged in account.
     * A account has to be logged in before calling this method.
     *
     * @return the list of active requests for the logged in account
     */
    @Override
    public List<IDeed> getMyActiveRequests() {
        return goodDeeds.getMyActiveRequests();
    }

    /**
     * Method for creating a new offer with the logged in account as the giving account.
     * A account has to be logged in before calling this method.
     *
     * @param subject     The subject of the offer.
     * @param description The description of the offer.
     */
    @Override
    public void createOffer(String subject, String description) {
        goodDeeds.createOffer(subject, description);
    }

    @Override
    public void createRequest(String subject, String description) {
        goodDeeds.createRequest(subject, description);
    }

    /**
     * Method for getting the currently assigned currentDeed.
     *
     * @return the deed to be sent ViewDeed
     */
    @Override
    public IDeed getCurrentDeed() {
        return goodDeeds.getCurrentDeed();
    }

    /**
     * Method for reassigning currentDeed.
     *
     * @param id UUID of the specific deed to be assigned.
     */
    @Override
    public void setCurrentDeed(UUID id) {
        goodDeeds.setCurrentdeed(id);
    }

    /**
     * Warning!
     * Removed the currently assigned Deed permanently.
     * Requires user to be logged in and Deed-owner.
     */
    @Override
    public void deleteCurrentDeed() {
        goodDeeds.deleteCurrentDeed();
    }

    /**
     * Checks if logged in account is the owner of the deed.
     *
     * @param deed The deed to check for ownership.
     * @return True if current account is owner of the deed.
     */
    @Override
    public boolean isDeedOwner(IDeed deed) {
        return goodDeeds.isDeedOwner(deed);
    }


    /**
     * Gets a list of active requests by calling goodDeeds
     * @return a list of deeds that are active requests
     */
    @Override
    public List<IDeed> getActiveRequests() {
        return goodDeeds.getActiveRequests();
    }

    /**
     * Gets a list of active offers by calling goodDeeds
     * @return a list of deeds that are active offers
     */
    @Override
    public List<IDeed> getActiveOffers() {
        return goodDeeds.getActiveOffers();
    }
}
