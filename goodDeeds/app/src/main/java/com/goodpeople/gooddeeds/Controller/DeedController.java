package com.goodpeople.gooddeeds.Controller;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepository;
import com.goodpeople.gooddeeds.Model.Repositories.DeedRepositoryImpl;
import com.goodpeople.gooddeeds.View.CreateAccount;

import java.util.UUID;

public class DeedController {

    private DeedRepository deedRepository = new DeedRepositoryImpl();
    private Account account = new Account("Olle", 41843, "olle@hotmail.com", "jajaja");
    private Deed deed = new Deed(account, "Gräsklippning", "Will do");


    public DeedController() {

    }


    public void editOffer(Deed deed, String subject, String description) {
        deedRepository.editOffer(deed, subject, description);

    }

    public String getDeedSubject() {
        return deed.getSubject();
    }

    public String getDeedDescription() {
        return deed.getDescription();
    }




}
