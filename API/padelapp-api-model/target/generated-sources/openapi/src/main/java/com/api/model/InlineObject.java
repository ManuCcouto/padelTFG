package com.api.model;

import java.util.Objects;
import com.api.model.InputBookingDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class InlineObject  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("bookings")
  @Valid
  private List<InputBookingDTO> bookings = new ArrayList<>();

  public InlineObject bookings(List<InputBookingDTO> bookings) {
    this.bookings = bookings;
    return this;
  }

  public InlineObject addBookingsItem(InputBookingDTO bookingsItem) {
    this.bookings.add(bookingsItem);
    return this;
  }

  /**
   * Get bookings
   * @return bookings
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<InputBookingDTO> getBookings() {
    return bookings;
  }

  public void setBookings(List<InputBookingDTO> bookings) {
    this.bookings = bookings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject inlineObject = (InlineObject) o;
    return Objects.equals(this.bookings, inlineObject.bookings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    
    sb.append("    bookings: ").append(toIndentedString(bookings)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

