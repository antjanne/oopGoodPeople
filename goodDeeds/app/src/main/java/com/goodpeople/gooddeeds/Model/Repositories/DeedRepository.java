package com.goodpeople.gooddeeds.Model.Repositories;

import java.util.UUID;

public interface DeedRepository {

    void addOffer(UUID id, String subject, String description) throws Exception;

}
