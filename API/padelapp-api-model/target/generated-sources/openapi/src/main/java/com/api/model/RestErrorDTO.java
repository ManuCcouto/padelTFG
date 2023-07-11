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
 * RestErrorDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-11T15:48:54.752435600+02:00[Europe/Madrid]")@lombok.Builder @lombok.NoArgsConstructor
@lombok.AllArgsConstructor

public class RestErrorDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("title")
  private String title;

  @JsonProperty("detail")
  private String detail;

  @JsonProperty("timestamp")
  private String timestamp;

  public RestErrorDTO status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP status code.
   * @return status
  */
  @ApiModelProperty(required = true, value = "The HTTP status code.")
  @NotNull


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public RestErrorDTO title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The reason phrase of the HTTP error.
   * @return title
  */
  @ApiModelProperty(required = true, value = "The reason phrase of the HTTP error.")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public RestErrorDTO detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * Additional details of the error.
   * @return detail
  */
  @ApiModelProperty(required = true, value = "Additional details of the error.")
  @NotNull


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public RestErrorDTO timestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The timestamp when the error occurred.
   * @return timestamp
  */
  @ApiModelProperty(required = true, value = "The timestamp when the error occurred.")
  @NotNull


  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestErrorDTO restErrorDTO = (RestErrorDTO) o;
    return Objects.equals(this.status, restErrorDTO.status) &&
        Objects.equals(this.title, restErrorDTO.title) &&
        Objects.equals(this.detail, restErrorDTO.detail) &&
        Objects.equals(this.timestamp, restErrorDTO.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, title, detail, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestErrorDTO {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

