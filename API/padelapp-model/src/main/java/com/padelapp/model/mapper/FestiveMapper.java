package com.padelapp.model.mapper;

import com.api.model.FestiveDTO;
import com.padelapp.entities.Festive;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {OffsetDateTimeMapper.class})
public interface FestiveMapper {
        @Named("FestiveDTO")
        @Mapping(source = "id", target = "festiveId")
        @Mapping(source = "date", target = "date", qualifiedByName="OffsetDateTime")
        FestiveDTO toDTO(Festive festive);
}
