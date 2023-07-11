package com.api.model;

import java.util.Objects;
import com.api.model.BookingType;
import com.api.model.BookingVisibility;
import com.api.model.ResourceDTO;
import com.api.model.UserBooking;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BookingDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class BookingDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("idBooking")
  private Long idBooking;

  @JsonProperty("resourceDTO")
  private ResourceDTO resourceDTO;

  @JsonProperty("starDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime starDate;

  @JsonProperty("endDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  @JsonProperty("ownerUser")
  private UserBooking ownerUser;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("guessts")
  private UserBooking guessts;

  @JsonProperty("bookingType")
  private BookingType bookingType;

  @JsonProperty("bookingVisibility")
  private BookingVisibility bookingVisibility;

  public BookingDTO idBooking(Long idBooking) {
    this.idBooking = idBooking;
    return this;
  }

  /**
   * Get idBooking
   * @return idBooking
  */
  @ApiModelProperty(example = "10", value = "")


  public Long getIdBooking() {
    return idBooking;
  }

  public void setIdBooking(Long idBooking) {
    this.idBooking = idBooking;
  }

  public BookingDTO resourceDTO(ResourceDTO resourceDTO) {
    this.resourceDTO = resourceDTO;
    return this;
  }

  /**
   * Get resourceDTO
   * @return resourceDTO
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResourceDTO getResourceDTO() {
    return resourceDTO;
  }

  public void setResourceDTO(ResourceDTO resourceDTO) {
    this.resourceDTO = resourceDTO;
  }

  public BookingDTO starDate(OffsetDateTime starDate) {
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

  public BookingDTO endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public BookingDTO ownerUser(UserBooking ownerUser) {
    this.ownerUser = ownerUser;
    return this;
  }

  /**
   * Get ownerUser
   * @return ownerUser
  */
  @ApiModelProperty(value = "")

  @Valid

  public UserBooking getOwnerUser() {
    return ownerUser;
  }

  public void setOwnerUser(UserBooking ownerUser) {
    this.ownerUser = ownerUser;
  }

  public BookingDTO price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public BookingDTO guessts(UserBooking guessts) {
    this.guessts = guessts;
    return this;
  }

  /**
   * Get guessts
   * @return guessts
  */
  @ApiModelProperty(value = "")

  @Valid

  public UserBooking getGuessts() {
    return guessts;
  }

  public void setGuessts(UserBooking guessts) {
    this.guessts = guessts;
  }

  public BookingDTO bookingType(BookingType bookingType) {
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

  public BookingDTO bookingVisibility(BookingVisibility bookingVisibility) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingDTO bookingDTO = (BookingDTO) o;
    return Objects.equals(this.idBooking, bookingDTO.idBooking) &&
        Objects.equals(this.resourceDTO, bookingDTO.resourceDTO) &&
        Objects.equals(this.starDate, bookingDTO.starDate) &&
        Objects.equals(this.endDate, bookingDTO.endDate) &&
        Objects.equals(this.ownerUser, bookingDTO.ownerUser) &&
        Objects.equals(this.price, bookingDTO.price) &&
        Objects.equals(this.guessts, bookingDTO.guessts) &&
        Objects.equals(this.bookingType, bookingDTO.bookingType) &&
        Objects.equals(this.bookingVisibility, bookingDTO.bookingVisibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idBooking, resourceDTO, starDate, endDate, ownerUser, price, guessts, bookingType, bookingVisibility);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDTO {\n");
    
    sb.append("    idBooking: ").append(toIndentedString(idBooking)).append("\n");
    sb.append("    resourceDTO: ").append(toIndentedString(resourceDTO)).append("\n");
    sb.append("    starDate: ").append(toIndentedString(starDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    ownerUser: ").append(toIndentedString(ownerUser)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    guessts: ").append(toIndentedString(guessts)).append("\n");
    sb.append("    bookingType: ").append(toIndentedString(bookingType)).append("\n");
    sb.append("    bookingVisibility: ").append(toIndentedString(bookingVisibility)).append("\n");
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

