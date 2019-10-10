package com.goodpeople.gooddeeds.Model.Repositories;


import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.List;

public interface DeedRepository {

     List<IDeed> getDeeds();

     List<IDeed> getMyActiveOffers();

     List<IDeed> getMyActiveRequests();

     void createOffer(String subject, String description);
}
