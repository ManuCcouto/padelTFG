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
public enum ResourceDTOType {
  
  PADEL("PADEL"),
  
  ARENA("ARENA"),
  
  GYM("GYM"),
  
  ECOWASH("ECOWASH");

  private String value;

  ResourceDTOType(String value) {
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
  public static ResourceDTOType fromValue(String value) {
    for (ResourceDTOType b : ResourceDTOType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

