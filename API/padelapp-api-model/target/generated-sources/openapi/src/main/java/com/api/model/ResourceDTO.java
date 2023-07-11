package com.api.model;

import java.util.Objects;
import com.api.model.ResourceDTOType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResourceDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class ResourceDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("number")
  private Integer number;

  @JsonProperty("name")
  private String name;

  @JsonProperty("resourceDTOType")
  private ResourceDTOType resourceDTOType;

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

  public ResourceDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "2", value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ResourceDTO number(Integer number) {
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

  public ResourceDTO name(String name) {
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

  public ResourceDTO resourceDTOType(ResourceDTOType resourceDTOType) {
    this.resourceDTOType = resourceDTOType;
    return this;
  }

  /**
   * Get resourceDTOType
   * @return resourceDTOType
  */
  @ApiModelProperty(value = "")

  @Valid

  public ResourceDTOType getResourceDTOType() {
    return resourceDTOType;
  }

  public void setResourceDTOType(ResourceDTOType resourceDTOType) {
    this.resourceDTOType = resourceDTOType;
  }

  public ResourceDTO timeSlot(Integer timeSlot) {
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

  public ResourceDTO startTimeSlot(String startTimeSlot) {
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

  public ResourceDTO endTimeSlot(String endTimeSlot) {
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

  public ResourceDTO basePrice(Double basePrice) {
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

  public ResourceDTO daysInAdvance(Integer daysInAdvance) {
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
    ResourceDTO resourceDTO = (ResourceDTO) o;
    return Objects.equals(this.id, resourceDTO.id) &&
        Objects.equals(this.number, resourceDTO.number) &&
        Objects.equals(this.name, resourceDTO.name) &&
        Objects.equals(this.resourceDTOType, resourceDTO.resourceDTOType) &&
        Objects.equals(this.timeSlot, resourceDTO.timeSlot) &&
        Objects.equals(this.startTimeSlot, resourceDTO.startTimeSlot) &&
        Objects.equals(this.endTimeSlot, resourceDTO.endTimeSlot) &&
        Objects.equals(this.basePrice, resourceDTO.basePrice) &&
        Objects.equals(this.daysInAdvance, resourceDTO.daysInAdvance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, name, resourceDTOType, timeSlot, startTimeSlot, endTimeSlot, basePrice, daysInAdvance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resourceDTOType: ").append(toIndentedString(resourceDTOType)).append("\n");
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

