package com.goodpeople.gooddeeds.Model.Repositories;

<<<<<<< HEAD
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

=======
import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

import java.util.List;
>>>>>>> master
import java.util.UUID;

public class DeedRepositoryImpl implements DeedRepository {

    private GoodDeeds goodDeeds = GoodDeeds.getGoodDeeds();

<<<<<<< HEAD

=======
    @Override
    public List<IDeed> getDeeds() {
        return goodDeeds.getDeeds();
    }

    @Override
    public List<IDeed> getMyOffers() {
        return goodDeeds.getMyOffers();
    }

    @Override
>>>>>>> master
    public void createOffer(String subject, String description) {
        goodDeeds.createOffer(subject, description);
    }

<<<<<<< HEAD

    @Override
    public void editOffer(Deed deed, String subject, String description){
        goodDeeds.editOffer(deed, subject, description);

    }
=======
    @Override
    public IDeed getCurrentDeed() {
        return goodDeeds.getCurrentDeed();
    }

    @Override
    public void setCurrentDeed(UUID id) {
        goodDeeds.setCurrentdeed(id);
    }


>>>>>>> master
}
