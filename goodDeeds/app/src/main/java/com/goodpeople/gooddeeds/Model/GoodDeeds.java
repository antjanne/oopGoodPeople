package com.goodpeople.gooddeeds.Model;

import com.goodpeople.gooddeeds.Model.Entities.Account;
import com.goodpeople.gooddeeds.Model.Entities.Deed;

import java.util.List;

public class GoodDeeds {

    List<Deed> offers;
    List<Account> accounts;

    public GoodDeeds() {
    }

    public List<Deed> getOffers() {
        return offers;
    }
}
