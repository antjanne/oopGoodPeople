package com.goodpeople.gooddeeds.Model.Repositories;


import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.List;
import java.util.UUID;

/**
 * Defines the interface for handling deed data between service and data handler
 */

public interface DeedRepository {

    List<IDeed> getDeeds();

    List<IDeed> getMyOffers();

    void createOffer(String subject, String description);

    IDeed getCurrentDeed();

    void setCurrentDeed(UUID id);
}
