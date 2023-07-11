package com.padelapp.model.mapper;

import com.api.model.BookingDTO;
import com.padelapp.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {OffsetDateTimeMapper.class,ResourceMapper.class })
public interface BookingMapper {

    @Mapping(source = "id", target = "idBooking")
    @Mapping(source = "startTime", target = "starDate", qualifiedByName="OffsetLocalDateTime")
    @Mapping(source = "endTime", target = "endDate",qualifiedByName="OffsetLocalDateTime")
    @Mapping(source = "bookingType.code", target = "bookingType", qualifiedByName = "toBookingType")
    @Mapping(source = "resource", target = "resourceDTO", qualifiedByName = "ResourceMapper")
    @Mapping(target = "ownerUser", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "guessts", ignore = true)
    BookingDTO toBookingDTO(Booking booking);
    List<BookingDTO> toBookingDTOList(List<Booking> booking);
}
