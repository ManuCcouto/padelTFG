package com.api.model;

import java.util.Objects;
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
 * MemberClub
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class MemberClub  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("startDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @JsonProperty("endTDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTDate;

  @JsonProperty("dni")
  private String dni;

  @JsonProperty("onHold")
  private Boolean onHold;

  public MemberClub startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  */
  @ApiModelProperty(example = "2022-01-01T00:00Z", value = "")

  @Valid

  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public MemberClub endTDate(OffsetDateTime endTDate) {
    this.endTDate = endTDate;
    return this;
  }

  /**
   * Get endTDate
   * @return endTDate
  */
  @ApiModelProperty(example = "2022-12-31T23:59:59Z", value = "")

  @Valid

  public OffsetDateTime getEndTDate() {
    return endTDate;
  }

  public void setEndTDate(OffsetDateTime endTDate) {
    this.endTDate = endTDate;
  }

  public MemberClub dni(String dni) {
    this.dni = dni;
    return this;
  }

  /**
   * Get dni
   * @return dni
  */
  @ApiModelProperty(example = "12345678A", value = "")


  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public MemberClub onHold(Boolean onHold) {
    this.onHold = onHold;
    return this;
  }

  /**
   * Get onHold
   * @return onHold
  */
  @ApiModelProperty(example = "false", value = "")


  public Boolean getOnHold() {
    return onHold;
  }

  public void setOnHold(Boolean onHold) {
    this.onHold = onHold;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberClub memberClub = (MemberClub) o;
    return Objects.equals(this.startDate, memberClub.startDate) &&
        Objects.equals(this.endTDate, memberClub.endTDate) &&
        Objects.equals(this.dni, memberClub.dni) &&
        Objects.equals(this.onHold, memberClub.onHold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endTDate, dni, onHold);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberClub {\n");
    
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endTDate: ").append(toIndentedString(endTDate)).append("\n");
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    onHold: ").append(toIndentedString(onHold)).append("\n");
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

