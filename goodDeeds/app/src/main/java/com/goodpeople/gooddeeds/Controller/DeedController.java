package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Entities.IDeed;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;

import java.util.List;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();


    public DeedController() {
    }


    public List<IDeed> showOffersHandler() {
        return (deedRepository.getDeeds());
    }

    public List<IDeed> showMyOffersHandler() {
        return (deedRepository.getMyOffers());
    }

    public void createOfferHandler(String subject, String description) {
        deedRepository.createOffer(subject, description);
    }

}
