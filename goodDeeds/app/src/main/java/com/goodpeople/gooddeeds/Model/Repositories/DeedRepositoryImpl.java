package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.List;
import java.util.UUID;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    @Override
    public List<IDeed> getDeeds() {
        return goodDeeds.getDeeds();
    }

    @Override
    public List<IDeed> getMyActiveOffers() {
        return goodDeeds.getMyActiveOffers();
    }

    @Override
    public List<IDeed> getMyActiveRequests() {
        return goodDeeds.getMyActiveRequests();
    }

    @Override
    public void createOffer(String subject, String description) {
        goodDeeds.createOffer(subject, description);
    }

    @Override
    public IDeed getCurrentDeed() {
        return goodDeeds.getCurrentDeed();
    }

    @Override
    public void setCurrentDeed(UUID id) {
        goodDeeds.setCurrentdeed(id);
    }


}
