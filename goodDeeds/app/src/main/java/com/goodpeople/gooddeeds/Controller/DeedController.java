package com.goodpeople.gooddeeds.Controller;

<<<<<<< HEAD
import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
=======
import com.goodpeople.gooddeeds.Model.Entities.IDeed;
>>>>>>> master
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;
import com.goodpeople.gooddeeds.View.CreateAccount;

import java.util.UUID;

import java.util.List;
import java.util.UUID;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();
    private Deed deed;


    public DeedController() {

    }


<<<<<<< HEAD
=======
    public List<IDeed> showOffersHandler() {
        return (deedRepository.getDeeds());
    }

    public List<IDeed> showMyOffersHandler() {
        return (deedRepository.getMyOffers());
    }

>>>>>>> master
    public void createOfferHandler(String subject, String description) {
        deedRepository.createOffer(subject, description);
    }

<<<<<<< HEAD

    public void editOfferHandler(Deed deed, String subject, String description) {
        deedRepository.editOffer(deed, subject, description);

    }

    public String getDeedSubject() {
        return deed.getSubject();
    }

    public String getDeedDescription() {
        return deed.getDescription();
    }


=======
    public IDeed getCurrentDeedHandler() {
        return deedRepository.getCurrentDeed();
    }

    public void setCurrentDeedHandler(UUID uuid) {
        deedRepository.setCurrentDeed(uuid);
    }

>>>>>>> master
}
