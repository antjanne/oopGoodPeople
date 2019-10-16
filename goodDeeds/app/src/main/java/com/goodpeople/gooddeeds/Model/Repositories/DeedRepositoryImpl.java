package com.goodpeople.gooddeeds.Model.Repositories;


import com.goodpeople.gooddeeds.Model.GoodDeeds;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import java.util.List;
import java.util.UUID;

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


    @Override
    public void editOffer(String subject, String description){
        goodDeeds.editOffer(subject, description);

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
