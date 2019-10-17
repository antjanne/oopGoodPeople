package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Deed;



import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.List;
import java.util.UUID;

public interface DeedRepository {

    List<IDeed> getDeeds();

    List<IDeed> getMyActiveOffers();

    List<IDeed> getMyActiveRequests();

    void createOffer(String subject, String description);

<<<<<<< HEAD

    void editOffer(String subject, String description);

=======
    void createRequest(String subject, String description);
>>>>>>> origin/master

    IDeed getCurrentDeed();

    void setCurrentDeed(UUID id);

<<<<<<< HEAD
=======
    List<IDeed> getActiveRequests();

    List<IDeed> getActiveOffers();
>>>>>>> origin/master
}
