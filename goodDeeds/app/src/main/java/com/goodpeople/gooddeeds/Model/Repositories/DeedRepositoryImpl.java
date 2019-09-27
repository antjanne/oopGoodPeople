package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.GoodDeeds;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    public void createOffer(String subject, String description) {
        goodDeeds.createOffer(subject, description);
    }
}
