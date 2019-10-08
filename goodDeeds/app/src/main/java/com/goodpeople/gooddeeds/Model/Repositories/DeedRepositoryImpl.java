package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.ArrayList;
import java.util.List;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();


    @Override
    public List<IDeed> getDeeds() {
        List<IDeed> deeds = new ArrayList<>();
        for (IDeed d : goodDeeds.getDeeds()) {
            deeds.add(d);
        }
        return deeds;
    }

    @Override
    public List<IDeed> getMyOffers() {
        List<IDeed> deeds = new ArrayList<>();
        for (IDeed d : goodDeeds.getMyOffers()) {
            deeds.add(d);
        }
        return deeds;
    }
    @Override
    public void createOffer(String subject, String description) {
        goodDeeds.createOffer(subject, description);
    }
}
