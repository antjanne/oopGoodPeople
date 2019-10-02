package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Deed;

import java.util.List;

public interface DeedRepository {

    public List<Deed> getDeeds();
}
