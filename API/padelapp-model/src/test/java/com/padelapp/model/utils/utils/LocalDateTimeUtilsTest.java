package com.padelapp.model.utils.utils;

import com.padelapp.model.utils.LocalDateTimeUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class LocalDateTimeUtilsTest {

    @InjectMocks
    LocalDateTimeUtils ldtu;

    @Test
    public void now() {
      ZoneOffset zo = ZoneId.of("Europe/Berlin").getRules().getOffset(LocalDateTime.now());
      assertNotNull(ldtu.now(zo), "now() test OK");
    }

    @Test
    public void nowNull() {
      assertNotNull(ldtu.now(null), "nowNull() test OK");
    }

    @Test
    public void ofInstantNull() {
      assertNotNull(ldtu.ofInstant(), "ofInstantNull() test OK");
    }

    @Test
    public void ofInstantZoneId() {
      assertNotNull(ldtu.ofInstant(Instant.now(), ZoneId.of("Europe/Berlin")), "ofInstantZoneId() test OK");
    }

    @Test
    public void ofInstantZoneOffset() {
      assertNotNull(ldtu.ofInstant(Instant.now(), ZoneId.of("Europe/Berlin").getRules().getOffset(LocalDateTime.now())),
              "ofInstantZoneOffset() test OK");
    }
}
