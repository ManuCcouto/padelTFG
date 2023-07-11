package com.padelapp.model.mapper;


import com.padelapp.entities.Resource;
import org.mapstruct.*;
import com.api.model.ResourceDTO;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ResourceMapper {
    @Named("ResourceMapper")
    @Mapping(target = "timeSlot", ignore = true)
    @Mapping(target = "startTimeSlot", source = "startTimeSlot", dateFormat = "HH:mm:ss")
    @Mapping(target = "endTimeSlot", source = "endTimeSlot", dateFormat = "HH:mm:ss")
    ResourceDTO toDTO(Resource resource);

}
