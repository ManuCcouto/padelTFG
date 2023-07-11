package com.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InputResourceDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class InputResourceDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("resourceDTOActivity")
  private String resourceDTOActivity;

  @JsonProperty("timeSlot")
  private Integer timeSlot;

  @JsonProperty("startTimeSlot")
  private String startTimeSlot;

  @JsonProperty("endTimeSlot")
  private String endTimeSlot;

  @JsonProperty("basePrice")
  private Double basePrice;

  @JsonProperty("daysInAdvance")
  private Integer daysInAdvance;

  public InputResourceDTO number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  */
  @ApiModelProperty(example = "12", value = "")


  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public InputResourceDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(example = "Pista central", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InputResourceDTO resourceDTOActivity(String resourceDTOActivity) {
    this.resourceDTOActivity = resourceDTOActivity;
    return this;
  }

  /**
   * Get resourceDTOActivity
   * @return resourceDTOActivity
  */
  @ApiModelProperty(example = "Padel", value = "")


  public String getResourceDTOActivity() {
    return resourceDTOActivity;
  }

  public void setResourceDTOActivity(String resourceDTOActivity) {
    this.resourceDTOActivity = resourceDTOActivity;
  }

  public InputResourceDTO timeSlot(Integer timeSlot) {
    this.timeSlot = timeSlot;
    return this;
  }

  /**
   * reservable time slot
   * @return timeSlot
  */
  @ApiModelProperty(example = "90", value = "reservable time slot")


  public Integer getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(Integer timeSlot) {
    this.timeSlot = timeSlot;
  }

  public InputResourceDTO startTimeSlot(String startTimeSlot) {
    this.startTimeSlot = startTimeSlot;
    return this;
  }

  /**
   * Get startTimeSlot
   * @return startTimeSlot
  */
  @ApiModelProperty(example = "09:00:00", value = "")


  public String getStartTimeSlot() {
    return startTimeSlot;
  }

  public void setStartTimeSlot(String startTimeSlot) {
    this.startTimeSlot = startTimeSlot;
  }

  public InputResourceDTO endTimeSlot(String endTimeSlot) {
    this.endTimeSlot = endTimeSlot;
    return this;
  }

  /**
   * Get endTimeSlot
   * @return endTimeSlot
  */
  @ApiModelProperty(example = "00:00:00", value = "")


  public String getEndTimeSlot() {
    return endTimeSlot;
  }

  public void setEndTimeSlot(String endTimeSlot) {
    this.endTimeSlot = endTimeSlot;
  }

  public InputResourceDTO basePrice(Double basePrice) {
    this.basePrice = basePrice;
    return this;
  }

  /**
   * Get basePrice
   * @return basePrice
  */
  @ApiModelProperty(example = "5.5", value = "")


  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public InputResourceDTO daysInAdvance(Integer daysInAdvance) {
    this.daysInAdvance = daysInAdvance;
    return this;
  }

  /**
   * Get daysInAdvance
   * @return daysInAdvance
  */
  @ApiModelProperty(example = "3", value = "")


  public Integer getDaysInAdvance() {
    return daysInAdvance;
  }

  public void setDaysInAdvance(Integer daysInAdvance) {
    this.daysInAdvance = daysInAdvance;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputResourceDTO inputResourceDTO = (InputResourceDTO) o;
    return Objects.equals(this.number, inputResourceDTO.number) &&
        Objects.equals(this.name, inputResourceDTO.name) &&
        Objects.equals(this.resourceDTOActivity, inputResourceDTO.resourceDTOActivity) &&
        Objects.equals(this.timeSlot, inputResourceDTO.timeSlot) &&
        Objects.equals(this.startTimeSlot, inputResourceDTO.startTimeSlot) &&
        Objects.equals(this.endTimeSlot, inputResourceDTO.endTimeSlot) &&
        Objects.equals(this.basePrice, inputResourceDTO.basePrice) &&
        Objects.equals(this.daysInAdvance, inputResourceDTO.daysInAdvance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name, resourceDTOActivity, timeSlot, startTimeSlot, endTimeSlot, basePrice, daysInAdvance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InputResourceDTO {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceDTOActivity: ").append(toIndentedString(resourceDTOActivity)).append("\n");
    sb.append("    timeSlot: ").append(toIndentedString(timeSlot)).append("\n");
    sb.append("    startTimeSlot: ").append(toIndentedString(startTimeSlot)).append("\n");
    sb.append("    endTimeSlot: ").append(toIndentedString(endTimeSlot)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
    sb.append("    daysInAdvance: ").append(toIndentedString(daysInAdvance)).append("\n");
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

