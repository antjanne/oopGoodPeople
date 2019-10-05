package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.UUID;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

    @Override
    public void editOffer(Deed deed, String subject, String description){
        goodDeeds.editOffer(deed, subject, description);

    }


}
