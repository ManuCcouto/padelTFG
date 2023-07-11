package com.padelapp.model.mapper;

import com.api.model.BookingType;
import org.mapstruct.Mapper;
import org.mapstruct.Named;


@Mapper
public interface BookingTypeMapper {

    @Named("toBookingType")
    default BookingType toBookingType(String value) {
        return BookingType.valueOf(value);
    }
}
