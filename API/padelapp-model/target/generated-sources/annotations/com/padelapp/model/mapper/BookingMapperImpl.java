package com.padelapp.model.mapper;

import com.api.model.BookingDTO;
import com.api.model.BookingDTO.BookingDTOBuilder;
import com.api.model.BookingType;
import com.padelapp.entities.Booking;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T15:48:58+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Autowired
    private OffsetDateTimeMapper offsetDateTimeMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public BookingDTO toBookingDTO(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        BookingDTOBuilder bookingDTO = BookingDTO.builder();

        bookingDTO.idBooking( booking.getId() );
        bookingDTO.resourceDTO( resourceMapper.toDTO( booking.getResource() ) );
        bookingDTO.endDate( offsetDateTimeMapper.mapLocalDateTime( booking.getEndTime() ) );
        bookingDTO.starDate( offsetDateTimeMapper.mapLocalDateTime( booking.getStartTime() ) );
        String code = bookingBookingTypeCode( booking );
        if ( code != null ) {
            bookingDTO.bookingType( Enum.valueOf( BookingType.class, code ) );
        }

        return bookingDTO.build();
    }

    @Override
    public List<BookingDTO> toBookingDTOList(List<Booking> booking) {
        if ( booking == null ) {
            return null;
        }

        List<BookingDTO> list = new ArrayList<BookingDTO>( booking.size() );
        for ( Booking booking1 : booking ) {
            list.add( toBookingDTO( booking1 ) );
        }

        return list;
    }

    private String bookingBookingTypeCode(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        com.padelapp.entities.BookingType bookingType = booking.getBookingType();
        if ( bookingType == null ) {
            return null;
        }
        String code = bookingType.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }
}
