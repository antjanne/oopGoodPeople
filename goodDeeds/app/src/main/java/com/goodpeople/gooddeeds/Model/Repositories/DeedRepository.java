package com.goodpeople.gooddeeds.Model.Repositories;

import java.util.UUID;

public interface DeedRepository {

    void editOffer(UUID id, String subject, String description);

}
