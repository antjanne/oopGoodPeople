package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Deed;



public interface DeedRepository {

    void createOffer(String subject, String description);

    void editOffer(Deed deed, String subject, String description);


}
