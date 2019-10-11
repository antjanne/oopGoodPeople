package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.List;

/**
 * Handles the layer between service and data handler
 */

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    @Override
    public List<IDeed> getDeeds() {
        return goodDeeds.getDeeds();
    }

    @Override
    public List<IDeed> getMyOffers() {
        return goodDeeds.getMyOffers();
    }

    @Override
    public void createOffer(String subject, String description) {
        goodDeeds.createOffer(subject, description);
    }
}
