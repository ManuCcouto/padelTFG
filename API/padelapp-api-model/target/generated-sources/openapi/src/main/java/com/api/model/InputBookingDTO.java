package com.api.model;

import java.util.Objects;
import com.api.model.BookingType;
import com.api.model.BookingVisibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InputBookingDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class InputBookingDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("resource")
  private Integer resource;

  @JsonProperty("starDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime starDate;

  @JsonProperty("endDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  @JsonProperty("user")
  private Integer user;

  @JsonProperty("bookingType")
  private BookingType bookingType;

  @JsonProperty("guessts")
  @Valid
  private List<String> guessts = null;

  @JsonProperty("bookingVisibility")
  private BookingVisibility bookingVisibility;

  @JsonProperty("level")
  private Integer level;

  public InputBookingDTO resource(Integer resource) {
    this.resource = resource;
    return this;
  }

  /**
   * Get resource
   * @return resource
  */
  @ApiModelProperty(example = "6", value = "")


  public Integer getResource() {
    return resource;
  }

  public void setResource(Integer resource) {
    this.resource = resource;
  }

  public InputBookingDTO starDate(OffsetDateTime starDate) {
    this.starDate = starDate;
    return this;
  }

  /**
   * Get starDate
   * @return starDate
  */
  @ApiModelProperty(example = "2017-07-21T17:30Z", value = "")

  @Valid

  public OffsetDateTime getStarDate() {
    return starDate;
  }

  public void setStarDate(OffsetDateTime starDate) {
    this.starDate = starDate;
  }

  public InputBookingDTO endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public InputBookingDTO user(Integer user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Integer getUser() {
    return user;
  }

  public void setUser(Integer user) {
    this.user = user;
  }

  public InputBookingDTO bookingType(BookingType bookingType) {
    this.bookingType = bookingType;
    return this;
  }

  /**
   * Get bookingType
   * @return bookingType
  */
  @ApiModelProperty(value = "")

  @Valid

  public BookingType getBookingType() {
    return bookingType;
  }

  public void setBookingType(BookingType bookingType) {
    this.bookingType = bookingType;
  }

  public InputBookingDTO guessts(List<String> guessts) {
    this.guessts = guessts;
    return this;
  }

  public InputBookingDTO addGuesstsItem(String guesstsItem) {
    if (this.guessts == null) {
      this.guessts = new ArrayList<>();
    }
    this.guessts.add(guesstsItem);
    return this;
  }

  /**
   * Get guessts
   * @return guessts
  */
  @ApiModelProperty(value = "")


  public List<String> getGuessts() {
    return guessts;
  }

  public void setGuessts(List<String> guessts) {
    this.guessts = guessts;
  }

  public InputBookingDTO bookingVisibility(BookingVisibility bookingVisibility) {
    this.bookingVisibility = bookingVisibility;
    return this;
  }

  /**
   * Get bookingVisibility
   * @return bookingVisibility
  */
  @ApiModelProperty(value = "")

  @Valid

  public BookingVisibility getBookingVisibility() {
    return bookingVisibility;
  }

  public void setBookingVisibility(BookingVisibility bookingVisibility) {
    this.bookingVisibility = bookingVisibility;
  }

  public InputBookingDTO level(Integer level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
  */
  @ApiModelProperty(example = "5", value = "")


  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputBookingDTO inputBookingDTO = (InputBookingDTO) o;
    return Objects.equals(this.resource, inputBookingDTO.resource) &&
        Objects.equals(this.starDate, inputBookingDTO.starDate) &&
        Objects.equals(this.endDate, inputBookingDTO.endDate) &&
        Objects.equals(this.user, inputBookingDTO.user) &&
        Objects.equals(this.bookingType, inputBookingDTO.bookingType) &&
        Objects.equals(this.guessts, inputBookingDTO.guessts) &&
        Objects.equals(this.bookingVisibility, inputBookingDTO.bookingVisibility) &&
        Objects.equals(this.level, inputBookingDTO.level);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, starDate, endDate, user, bookingType, guessts, bookingVisibility, level);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputBookingDTO {\n");
    
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    starDate: ").append(toIndentedString(starDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    bookingType: ").append(toIndentedString(bookingType)).append("\n");
    sb.append("    guessts: ").append(toIndentedString(guessts)).append("\n");
    sb.append("    bookingVisibility: ").append(toIndentedString(bookingVisibility)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
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

