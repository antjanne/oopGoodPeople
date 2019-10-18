package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Deed;



import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.List;
import java.util.UUID;

/**
 * Defines the interface for handling deed data between service and data handler
 */

public interface DeedRepository {

    List<IDeed> getDeeds();

    List<IDeed> getMyActiveOffers();

    List<IDeed> getMyActiveRequests();

    void createOffer(String subject, String description);



    void editOffer(String subject, String description);

    void createRequest(String subject, String description);

    IDeed getCurrentDeed();

    void setCurrentDeed(UUID id);

    List<IDeed> getActiveRequests();

    List<IDeed> getActiveOffers();

    void deleteCurrentDeed();


    boolean isMyActiveDeed();

}
