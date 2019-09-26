package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.UUID;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    @Override
    public void editOffer(UUID id, String subject, String description){
        goodDeeds.editOffer(id, subject, description);

    }


}
