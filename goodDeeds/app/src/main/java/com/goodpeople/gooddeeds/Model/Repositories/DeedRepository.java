package com.goodpeople.gooddeeds.Model.Repositories;

import com.goodpeople.gooddeeds.Model.Entities.Deed;

import java.util.List;

public interface DeedRepository {

     List<Deed> getDeeds();

     List<Deed> getMyDeeds();

}
