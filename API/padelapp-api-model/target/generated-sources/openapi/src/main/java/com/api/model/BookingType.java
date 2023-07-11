package com.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * booking type
 */
public enum BookingType {
  
  TOURNAMENT("TOURNAMENT"),
  
  TRAINING("TRAINING"),
  
  GAME("GAME"),
  
  MATCH_TELEGRAM("MATCH-TELEGRAM"),
  
  LEAGUE("LEAGUE");

  private String value;

  BookingType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BookingType fromValue(String value) {
    for (BookingType b : BookingType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

