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
 * FestiveDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class FestiveDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("festiveId")
  private Long festiveId;

  @JsonProperty("date")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime date;

  @JsonProperty("description")
  private String description;

  public FestiveDTO festiveId(Long festiveId) {
    this.festiveId = festiveId;
    return this;
  }

  /**
   * Get festiveId
   * @return festiveId
  */
  @ApiModelProperty(example = "10", value = "")


  public Long getFestiveId() {
    return festiveId;
  }

  public void setFestiveId(Long festiveId) {
    this.festiveId = festiveId;
  }

  public FestiveDTO date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public FestiveDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(example = "Reconquista de Vigo", value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FestiveDTO festiveDTO = (FestiveDTO) o;
    return Objects.equals(this.festiveId, festiveDTO.festiveId) &&
        Objects.equals(this.date, festiveDTO.date) &&
        Objects.equals(this.description, festiveDTO.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(festiveId, date, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FestiveDTO {\n");
    
    sb.append("    festiveId: ").append(toIndentedString(festiveId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

