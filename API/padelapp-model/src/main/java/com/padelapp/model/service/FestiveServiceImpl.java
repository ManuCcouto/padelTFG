package com.padelapp.model.service;

import com.api.model.FestiveDTO;
import com.padelapp.dao.FestiveDao;
import com.padelapp.entities.Festive;
import com.padelapp.model.mapper.FestiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FestiveServiceImpl {
    @Autowired
    private FestiveMapper festiveMapper;
    @Autowired
    private FestiveDao festiveDao;

   public  FestiveDTO getFestiveById(Integer id){
        Optional<Festive> festive=this.festiveDao.getFestiveById(id);
        FestiveDTO festiveDTO=null;
        if (festive.isPresent()){
            festiveDTO = this.festiveMapper.toDTO(festive.get());
        }
        return festiveDTO;
    }
}
