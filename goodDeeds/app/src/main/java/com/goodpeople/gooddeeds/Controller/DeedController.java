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

    private DeedRepository deedRepository = new DeedRepositoryImpl();


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

    /**
     * @return Gets the currently assigned currentDeed.
     */
    public IDeed getCurrentDeedHandler() {
        return deedRepository.getCurrentDeed();
    }

    /**
     * Reassigns currentDeed
     *
     * @param uuid the ID of new Deed to be assigned.
     */
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

    /**
     * Warning!
     * Removes the currently assigned Deed.
     * Requires user to be logged in and Deed-owner.
     */
    public void deleteCurrentDeedHandler() {
        deedRepository.deleteCurrentDeed();
    }

    /**
     * Checks if logged in account is the owner of currentDeed.
     *
     * @return True if current account is owner of currentDeed.
     */
    public boolean isMyActiveDeedHandler() {
        return deedRepository.isMyActiveDeed();
    }

    /**
     * Checks if a deed is claimed
     *
     * @return true if at least one of givingAccount or receivingAccount is not initialized
     * false otherwise
     */
    public boolean isClaimedHandler() {
        return deedRepository.isClaimed();
    }

    /**
     * Checks if the logged in account is the creator of the deed
     *
     * @return true if the logged in user created the deed
     * false otherwise
     */
    public boolean isMyOwnDeedHandler() {
        return deedRepository.isMyOwnDeed();
    }

    /**
     * Method for claiming the current deed
     */
    public void claimDeedHandler() {
        deedRepository.claimDeed();
    }

    /**
     * Method for marking a deed as done
     */
    public void deedIsDoneHandler() {
        deedRepository.deedIsDone();
    }

    /**
     * @return A list of deeds that are claimed and where the logged in account is
     * either giving or receiving account for the deed
     */
    public List<IDeed> getMyClaimedDeedsHandler() {
        return deedRepository.getMyClaimedDeeds();
    }

    /**
     * @return A list of deeds that are marked as done, where the logged in account is either
     * the giving or receiving account for the deed
     */
    public List<IDeed> getMyDoneDeedsHandler() {
        return deedRepository.getMyDoneDeeds();
    }


}

