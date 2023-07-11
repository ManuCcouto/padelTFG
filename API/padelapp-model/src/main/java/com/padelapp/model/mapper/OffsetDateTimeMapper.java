package com.padelapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {})
public interface OffsetDateTimeMapper {
    @Named("OffsetDateTime")
    default OffsetDateTime map(Timestamp value) {
        if (value == null) {
            return null;
        } else {
            LocalDateTime localDateTime = value.toLocalDateTime();
            ZoneOffset zoneOffset = ZoneOffset.UTC; // O utiliza la zona horaria que necesites
            return OffsetDateTime.of(localDateTime, zoneOffset);
        }
    }
        @Named("OffsetLocalDateTime")
        default OffsetDateTime mapLocalDateTime(LocalDateTime value) {
            if (value == null) {
                return null;
            } else {
                ZoneOffset zoneOffset = ZoneOffset.UTC; // O utiliza la zona horaria que necesites
                return OffsetDateTime.of(value, zoneOffset);
            }
        }
}
