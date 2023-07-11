package com.padelapp.model.mapper;

import com.api.model.FestiveDTO;
import com.api.model.FestiveDTO.FestiveDTOBuilder;
import com.padelapp.entities.Festive;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T15:48:58+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class FestiveMapperImpl implements FestiveMapper {

    @Autowired
    private OffsetDateTimeMapper offsetDateTimeMapper;

    @Override
    public FestiveDTO toDTO(Festive festive) {
        if ( festive == null ) {
            return null;
        }

        FestiveDTOBuilder festiveDTO = FestiveDTO.builder();

        festiveDTO.date( offsetDateTimeMapper.map( festive.getDate() ) );
        festiveDTO.festiveId( (long) festive.getId() );
        festiveDTO.description( festive.getDescription() );

        return festiveDTO.build();
    }
}
