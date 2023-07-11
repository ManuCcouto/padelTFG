package com.padelapp.dao;


import com.padelapp.entities.Festive;

import java.util.List;
import java.util.Optional;

public interface FestiveDao {
    List<Festive> getAllFestive();

    Optional<Festive> getFestiveById(Integer id);

    Optional<Festive> saveFestive(Festive festive);
    Optional<Festive> changeFestive(Festive festive);


}
