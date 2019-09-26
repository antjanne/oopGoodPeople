package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;

import java.util.List;
import java.util.UUID;

public class GoodDeeds {

    List<Deed> offers;
    List<Account> accounts;

    public GoodDeeds() {
    }

    public void editOffer(UUID id, String subject, String description) {
        for (int i = 0; i < offers.size(); i++ ) {
            if (offers.get(i).getId() == id) {
                offers.get(i).setSubject(subject);
                offers.get(i).setDescription(description);

            }
        } System.out.println("Deed not found");

    }


}
