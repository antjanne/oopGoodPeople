package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;

import java.util.UUID;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();


    public DeedController() {

    }


    public void editOffer(UUID id, String subject, String description) {
        deedRepository.editOffer(id, subject, description);

    }


}
