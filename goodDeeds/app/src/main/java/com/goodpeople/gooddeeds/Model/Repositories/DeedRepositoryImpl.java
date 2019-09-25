package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.UUID;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    public void addOffer(UUID id, String subject, String description) throws Exception {
        goodDeeds.addOffer(id, subject, description);
    }
}
