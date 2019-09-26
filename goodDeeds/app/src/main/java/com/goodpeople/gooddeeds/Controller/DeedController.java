package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;


import java.util.UUID;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.GoodDeeds;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();


    public DeedController() {
    }

    /**
     * The addOffer method ...
     *
     * @param id the id of the account that offers the deed
     * @param subject the subject of the deed
     * @param description the description of the deed
     */
    public void addOffer(UUID id, String subject, String description) {
        try {
            deedRepository.addOffer(id, subject, description);
        } catch (Exception e) {
            System.out.println("Could not find giving account " + e.getMessage());
        }
    }
}
