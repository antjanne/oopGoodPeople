package com.goodpeople.gooddeeds.Controller;



import com.goodpeople.gooddeeds.Model.Entities.IDeed;

import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;


import java.util.UUID;

import java.util.List;
import java.util.UUID;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();
    private IDeed deed;


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



    public void editOfferHandler(String subject, String description) {
        deedRepository.editOffer(subject, description);

    }

    public String getDeedSubject() {
        return deed.getSubject();
    }

    public String getDeedDescription() {
        return deed.getDescription();
    }



    public IDeed getCurrentDeedHandler() {
        return deedRepository.getCurrentDeed();
    }

    public void setCurrentDeedHandler(UUID uuid) {
        deedRepository.setCurrentDeed(uuid);
    }

}
