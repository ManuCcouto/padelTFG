package com.padelapp.model.dao;

import com.padelapp.dao.FestiveDao;
import com.padelapp.entities.Festive;
import com.padelapp.repository.FestiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestiveDaoImpl implements FestiveDao {
    @Autowired
    private FestiveRepository festiveRepository;

    @Override
    public List<Festive> getAllFestive() {
      return  this.festiveRepository.findAll();
    }

    @Override
    public Optional<Festive> getFestiveById(Integer id) {
        return this.festiveRepository.findById(id);
    }

    @Override
    public Optional<Festive> saveFestive(Festive festive) {
        Festive save = this.festiveRepository.save(festive);
        return Optional.of(save);
    }

    @Override
    public Optional<Festive> changeFestive(Festive festive) {
        return Optional.empty();
    }
}
