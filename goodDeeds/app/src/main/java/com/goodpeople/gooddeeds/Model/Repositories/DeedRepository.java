package com.goodpeople.gooddeeds.Model.Repositories;


import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.List;
import java.util.UUID;

public interface DeedRepository {

    List<IDeed> getDeeds();

    List<IDeed> getMyActiveOffers();

    List<IDeed> getMyActiveRequests();

    void createOffer(String subject, String description);

    IDeed getCurrentDeed();

    void setCurrentDeed(UUID id);
}
