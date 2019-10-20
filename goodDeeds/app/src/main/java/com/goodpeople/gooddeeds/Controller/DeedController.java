package com.goodpeople.gooddeeds.Controller;


import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;

import java.util.List;
import java.util.UUID;


/**
 * Handles input from deed-views. Sends and fetches data to/from DeedRepository.
 */

public class DeedController {

    private final DeedRepository deedRepository = new DeedRepositoryImpl();

    public DeedController() {
    }

    public List<IDeed> showAllDeedsHandler() {
        return deedRepository.getDeeds();
    }

    /**
     * Method for getting the active offers for a logged in account.
     * A account has to be logged in before calling this method.
     *
     * @return the list of active offers for the logged in account
     */
    public List<IDeed> showMyActiveOffersHandler() {
        return deedRepository.getMyActiveOffers();
    }

    /**
     * Method for getting the active requests for a logged in account.
     * A account has to be logged in before calling this method.
     *
     * @return the list of active requests for the logged in account
     */
    public List<IDeed> showMyActiveRequestsHandler() {
        return deedRepository.getMyActiveRequests();
    }

    /**
     * Method for creating a new offer with the logged in account as the giving account.
     * A account has to be logged in before calling this method.
     *
     * @param subject     The subject of the offer.
     * @param description The description of the offer.
     */
    public void createOfferHandler(String subject, String description) {
        deedRepository.createOffer(subject, description);
    }

    public void editOfferHandler(String subject, String description) {
        deedRepository.editOffer(subject, description);
    }

    public String getDeedSubject() {
        return deedRepository.getCurrentDeed().getSubject();
    }

    public String getDeedDescription() {
        return deedRepository.getCurrentDeed().getDescription();
    }


    public void createRequestHandler(String subject, String description) {
        deedRepository.createRequest(subject, description);
    }


    public IDeed getCurrentDeedHandler() {
        return deedRepository.getCurrentDeed();
    }

    public void setCurrentDeedHandler(UUID uuid) {
        deedRepository.setCurrentDeed(uuid);
    }

    /**
     * Gets a list of active requests by calling deedRepository
     *
     * @return a list of active requests
     */
    public List<IDeed> showAllActiveRequests() {
        return deedRepository.getActiveRequests();
    }

    /**
     * Gets a list of active offers by calling deedRepository
     *
     * @return a list of active offers
     */
    public List<IDeed> showAllActiveOffers() {
        return deedRepository.getActiveOffers();
    }

    public boolean isMyActiveDeedHandler() {
        return deedRepository.isMyActiveDeed();
    }

    public boolean isClaimedHandler() {
        return deedRepository.isClaimed();
    }

    public boolean isMyOwnDeedHandler() {
        return deedRepository.isMyOwnDeed();
    }

    public void claimDeed() {
        deedRepository.claimDeed();
    }
}
