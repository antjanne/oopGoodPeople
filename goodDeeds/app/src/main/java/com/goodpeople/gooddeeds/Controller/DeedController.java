package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;

import java.util.List;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();


    public DeedController() {
    }


    public List<Deed> getOfferHandler(){
        return(deedRepository.getDeeds());
    }

    public List<Deed> getMyDeedsHandler() {
        return (deedRepository.getMyDeeds());
    }
    public void createOfferHandler(String subject, String description) {
        deedRepository.createOffer(subject, description);
    }
}
