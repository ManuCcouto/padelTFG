package com.padelapp.model.mapper;

import com.api.model.ResourceDTO;
import com.api.model.ResourceDTO.ResourceDTOBuilder;
import com.padelapp.entities.Resource;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T15:48:58+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class ResourceMapperImpl implements ResourceMapper {

    @Override
    public ResourceDTO toDTO(Resource resource) {
        if ( resource == null ) {
            return null;
        }

        ResourceDTOBuilder resourceDTO = ResourceDTO.builder();

        if ( resource.getEndTimeSlot() != null ) {
            resourceDTO.endTimeSlot( DateTimeFormatter.ofPattern( "HH:mm:ss" ).format( resource.getEndTimeSlot() ) );
        }
        if ( resource.getStartTimeSlot() != null ) {
            resourceDTO.startTimeSlot( DateTimeFormatter.ofPattern( "HH:mm:ss" ).format( resource.getStartTimeSlot() ) );
        }
        if ( resource.getId() != null ) {
            resourceDTO.id( resource.getId().longValue() );
        }
        resourceDTO.number( resource.getNumber() );
        resourceDTO.name( resource.getName() );
        resourceDTO.basePrice( resource.getBasePrice() );

        return resourceDTO.build();
    }
}
